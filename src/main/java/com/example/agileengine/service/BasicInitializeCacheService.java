package com.example.agileengine.service;

import com.example.agileengine.client.AgileEngineImageClient;
import com.example.agileengine.dto.AgileImageDTO;
import com.example.agileengine.dto.AgileImageRequestDTO;
import com.example.agileengine.model.AgileImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.PostConstruct;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@RequiredArgsConstructor
@Component
public class BasicInitializeCacheService implements InitializeCacheService {

    private final AgileEngineImageClient agileEngineImageClient;
    private final ImageCachingService imageCachingService;

    @Value("${caching.retry}")
    private int retry;

    @PostConstruct
    public void init() {
        this.fetchData();
    }

    @Scheduled(fixedDelayString = "${caching.refresh}")
    @Override
    public void fetchData() {
        int currentTry = 1;
        imageCachingService.reset();
        AtomicInteger currentPage = new AtomicInteger(1);
        AtomicReference<Boolean> hasMore = new AtomicReference<>(true);
        agileEngineImageClient.authenticate();
        do {
            try {
                Optional<AgileImageRequestDTO> agileImageRequestDTO = agileEngineImageClient.fetchImage(currentPage.get());
                agileImageRequestDTO.ifPresent(
                        response -> {
                            response.getPictures().forEach(this::getDetail);
                            currentPage.getAndIncrement();
                            hasMore.set(response.isHasMore());
                        }
                );
            } catch (HttpClientErrorException exception) {
                if (currentTry <= retry && exception.getRawStatusCode() == 401) {
                    agileEngineImageClient.authenticate();
                    currentTry++;
                } else {
                    log.error("Application was not able to fetch Data");
                    System.exit(0);
                }
            }
        }
        while (hasMore.get());
    }

    private void getDetail(AgileImageDTO agileImageDTO) {
        Optional<AgileImage> image = agileEngineImageClient.getImageDetail(agileImageDTO.getId());
        image.ifPresent(imageCachingService::cacheImage);
    }
}
