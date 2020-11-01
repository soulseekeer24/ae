package com.example.agileengine.client;

import com.example.agileengine.dto.AgileImageRequestDTO;
import com.example.agileengine.model.AgileImage;

import java.util.Optional;

public interface AgileEngineImageClient {
    Optional<AgileImageRequestDTO> fetchImage(int currentPage);

    Optional<AgileImage> getImageDetail(String id);

    void authenticate();
}
