package com.buythebookstore.entities.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RecommendationDto {

    @NotBlank
    private String recommendationContents;
}
