package com.example.agileengine.client;

import com.example.agileengine.dto.AgileImageRequestDTO;
import com.example.agileengine.dto.AuthRequestDTO;
import com.example.agileengine.model.AgileImage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class BasicAgileEngineImagesClient implements AgileEngineImageClient {

    private final String API_URL = "http://interview.agileengine.com";
    private final String API_KEY = "23567b218376f79d9415";
    private final int retry = 2;
    private final RestTemplate restTemplate = new RestTemplate();
    private String token;

    @Override
    public Optional<AgileImageRequestDTO> fetchImage(int currentPage) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        ResponseEntity<AgileImageRequestDTO> response = restTemplate.exchange(
                API_URL + "/images?page=" + currentPage, HttpMethod.GET, new HttpEntity(headers), AgileImageRequestDTO.class);
        return Optional.ofNullable(response.getBody());

    }

    @Override
    public Optional<AgileImage> getImageDetail(String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        ResponseEntity<AgileImage> response = restTemplate.exchange(
                API_URL + "/images/" + id, HttpMethod.GET, new HttpEntity(headers), AgileImage.class);
        return Optional.ofNullable(response.getBody());
    }

    @Override
    public void authenticate() {
        log.info("AUTHENTICATING");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<AuthRequestDTO> request = new HttpEntity<>(new AuthRequestDTO(API_KEY));

        ResponseEntity<Map> response = restTemplate.exchange(
                API_URL + "/auth", HttpMethod.POST, request, Map.class);

        response.getBody().computeIfPresent("token", (key, newToken) -> token = String.valueOf(newToken));
    }
}
