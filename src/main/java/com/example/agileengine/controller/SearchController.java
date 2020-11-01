package com.example.agileengine.controller;

import com.example.agileengine.dto.SearchResultDTO;
import com.example.agileengine.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
public class SearchController {

    private final SearchService searchService;

    @GetMapping("/search")
    public SearchResultDTO searchImages(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String camera,
            @RequestParam(required = false) String tags
    ) {
        return new SearchResultDTO(searchService.findMatching(author, camera, tags.split(",")));
    }
}
