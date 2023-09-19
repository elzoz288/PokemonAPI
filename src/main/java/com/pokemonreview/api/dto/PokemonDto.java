package com.pokemonreview.api.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class PokemonDto {
 private int id;
 @NotEmpty(message = "Pokemon name should not be empty")
 private String name;
 @NotEmpty(message = "Pokemon type should not be empty")
 private String type;

}
