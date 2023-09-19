package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;

public interface PokemonService {
    PokemonResponse getAllPokemon(int pageNo, int PageSize);
    PokemonDto getByID(int id);
    PokemonDto createPokemon(PokemonDto pokemonDto);

    PokemonDto updatePokemon(int id ,PokemonDto pokemonDto);

    PokemonDto deletePokemonByID(int id);

}
