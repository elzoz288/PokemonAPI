package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Pokemon;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ReviewDto {
    private  int id;
    @NotEmpty(message = "review title should not be empty")
    private  String title ;
    @NotEmpty(message = "review content should not be empty")
    private  String content ;
    private  int start;
    private Pokemon pokemon;
}
