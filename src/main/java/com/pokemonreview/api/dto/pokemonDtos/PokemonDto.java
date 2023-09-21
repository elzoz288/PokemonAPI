package com.pokemonreview.api.dto.pokemonDtos;

import lombok.Data;

import java.util.List;

@Data
public class PokemonDto {
 private int id;

 private String name;

 private String type;

 private List<ReviewPokemonDto> reviews;

}
