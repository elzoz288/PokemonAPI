package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.pokemonDtos.PokemonDto;
import com.pokemonreview.api.dto.pokemonDtos.PokemonResponse;
import com.pokemonreview.api.dto.pokemonDtos.PokemonSourceDto;

public interface PokemonService {
    PokemonResponse getAllPokemon(int pageNo, int PageSize);
    PokemonDto getByID(int id);
    PokemonDto createPokemon(PokemonSourceDto pokemonSource);

    PokemonDto updatePokemon(int id , PokemonSourceDto pokemonSource);

    PokemonDto deletePokemonByID(int id);

}
