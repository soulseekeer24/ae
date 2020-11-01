package com.example.agileengine.model;

import lombok.Data;

@Data
public class AgileImage {
    private String id;
    private String author;
    private String camera;
    private String tags;
    private String cropped_picture;
    private String full_picture;
}
