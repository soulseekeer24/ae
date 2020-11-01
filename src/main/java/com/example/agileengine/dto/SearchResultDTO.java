package com.example.agileengine.dto;

import com.example.agileengine.model.AgileImage;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchResultDTO {
    private Set<AgileImage> images;
}
