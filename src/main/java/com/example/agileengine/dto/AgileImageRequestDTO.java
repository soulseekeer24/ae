package com.example.agileengine.dto;

import lombok.Data;

import java.util.List;

@Data
public class AgileImageRequestDTO {
    private List<AgileImageDTO> pictures;
    private int page;
    private int pageCount;
    private boolean hasMore;
}

