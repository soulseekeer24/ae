package com.example.agileengine.service;

import com.example.agileengine.model.AgileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class BasicSearchService implements SearchService {

    private final ImageCachingService imageCachingService;

    @Override
    public Set<AgileImage> findMatching(String author, String camera, String[] tags) {
        final Set<AgileImage> searchResult = new HashSet<>();

        if (author != null) {
            searchResult.addAll(findByAuthor(author));
        }
        if (camera != null) {
            searchResult.addAll(findByCamera(camera.trim()));
        }
        if (tags != null) {
            searchResult.addAll(
                    Stream.of(tags).map(this::findByTag)
                            .flatMap(Collection::stream)
                            .collect(Collectors.toSet())
            );
        }
        return searchResult;
    }

    private Set<AgileImage> findByTag(String tag) {
        return imageCachingService.getByTag(tag);
    }

    private Set<AgileImage> findByCamera(String camera) {
        return imageCachingService.getByCamera(camera);
    }

    private Set<AgileImage> findByAuthor(String author) {
        return imageCachingService.getByAuthor(author);
    }
}
