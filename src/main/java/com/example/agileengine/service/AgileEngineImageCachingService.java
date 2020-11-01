package com.example.agileengine.service;

import com.example.agileengine.model.AgileImage;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class AgileEngineImageCachingService implements ImageCachingService {

    final Set<AgileImage> imageList = new HashSet<>();
    final HashMap<String, Set<AgileImage>> authorIndex = new HashMap<>();
    final HashMap<String, Set<AgileImage>> tagIndex = new HashMap<>();
    final HashMap<String, Set<AgileImage>> cameraIndex = new HashMap<>();


    @Override
    public void cacheImage(AgileImage img) {
        imageList.add(img);
        generateAuthorIndexes(img);
        generateTagIndexes(img);
        generateCameraIndexes(img);
    }

    @Override
    public Set<AgileImage> getByTag(String tag) {
        return tagIndex.getOrDefault(tag, new HashSet<>());
    }

    @Override
    public Set<AgileImage> getByAuthor(String author) {
        return authorIndex.getOrDefault(author, new HashSet<>());
    }

    @Override
    public Set<AgileImage> getByCamera(String camera) {
        return cameraIndex.getOrDefault(camera, new HashSet<>());
    }

    @Override
    public void reset() {
        imageList.clear();
        authorIndex.clear();
        tagIndex.clear();
        cameraIndex.clear();
    }

    private void generateTagIndexes(AgileImage img) {
        if (StringUtils.isEmpty(img.getTags())) {
            return;
        }
        Arrays.stream(img.getTags().split("#")).forEach(tag -> {
            Set<AgileImage> imagesByTag = tagIndex.getOrDefault(tag.trim(), new HashSet<>());
            imagesByTag.add(img);
            tagIndex.put(tag.trim(), imagesByTag);

        });
    }

    private void generateCameraIndexes(AgileImage img) {
        if (StringUtils.isEmpty(img.getCamera())) {
            return;
        }
        Set<AgileImage> imagesByCamera = cameraIndex.getOrDefault(img.getCamera().trim(), new HashSet<>());
        imagesByCamera.add(img);
        cameraIndex.put(img.getCamera().trim(), imagesByCamera);
    }

    private void generateAuthorIndexes(AgileImage img) {
        if (StringUtils.isEmpty(img.getAuthor())) {
            return;
        }
        Set<AgileImage> imagesByTag = authorIndex.getOrDefault(img.getAuthor().trim(), new HashSet<>());
        imagesByTag.add(img);
        authorIndex.put(img.getAuthor().trim(), imagesByTag);
    }


}
