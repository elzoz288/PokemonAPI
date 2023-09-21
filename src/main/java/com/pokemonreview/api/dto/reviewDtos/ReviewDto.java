package com.pokemonreview.api.dto.reviewDtos;

import lombok.Data;

@Data
public class ReviewDto {
    private  int id;
    private  String title ;
    private  String content ;
    private  int start;
    private PokemonReviewDto pokemon;
}
