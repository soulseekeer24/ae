package com.example.agileengine.service;

import com.example.agileengine.model.AgileImage;

import java.util.Set;

public interface SearchService {
    Set<AgileImage> findMatching(String author, String camera, String[] split);
}
