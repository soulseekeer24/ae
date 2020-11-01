package com.example.agileengine.service;

import com.example.agileengine.model.AgileImage;

import java.util.Set;


public interface ImageCachingService {

    void cacheImage(AgileImage img);

    Set<AgileImage> getByTag(String tag);

    Set<AgileImage> getByAuthor(String author);

    Set<AgileImage> getByCamera(String camera);

    void reset();

}
