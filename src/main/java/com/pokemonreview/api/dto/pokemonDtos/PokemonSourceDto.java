package com.pokemonreview.api.dto.pokemonDtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class PokemonSourceDto {
    private int id;
    @NotEmpty(message = "Pokemon name should not be empty")
    private String name;
    @NotEmpty(message = "Pokemon type should not be empty")
    private  String type ;
}
