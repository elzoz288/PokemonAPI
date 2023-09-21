package com.pokemonreview.api.dto.reviewDtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReviewSourceDto {
    private  int id;
    @NotEmpty(message = "review tittle could not be empty")
    private  String title ;
   @NotEmpty(message = "review content could not be empty")
    private  String content ;
    private  int start;
}
