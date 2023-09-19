package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.PokemonDto;
import com.pokemonreview.api.dto.PokemonResponse;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.models.Mappers;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PokemonServiceImpl implements PokemonService {
    private  final PokemonRepository pokemonRepository;
    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
         //mapping dto to pokemon to add the new value to the data base
        Pokemon pokemon= Mappers.mapToPokemonEntity(pokemonDto);

        Pokemon newpokemon = pokemonRepository.save(pokemon);
        //mapping pokemon to dto to return it as a response
        PokemonDto pokemonResponse = Mappers.mapToPokemonDto(newpokemon);
        return pokemonResponse;
    }

    @Override
    public PokemonResponse getAllPokemon(int pageNo,int pageSize) {   //getting data with pagination
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemons =pokemons.getContent();
         //using our mapper to map the Pokemon to dto
        List<PokemonDto> content = listOfPokemons.stream().map(Mappers::mapToPokemonDto).collect(Collectors.toList());

        PokemonResponse pokemonResponse = new PokemonResponse();
        pokemonResponse.setContent(content);
        pokemonResponse.setPageNo(pokemons.getNumber());
        pokemonResponse.setPageSize(pokemons.getSize());
        pokemonResponse.setTotalElements(pokemons.getTotalElements());
        pokemonResponse.setTotalPages(pokemons.getTotalPages());
        pokemonResponse.setLast(pokemons.isLast());
        return pokemonResponse;
    }

    @Override
    public PokemonDto getByID(int id) {
     Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(()-> new  PokemonNotFoundException("Pokemon could not be found by id "));
    return Mappers.mapToPokemonDto(pokemon);
    }

    @Override
    public PokemonDto updatePokemon(int id, PokemonDto pokemonDto) {
        Pokemon pokemon =pokemonRepository.findById(id)
                .orElseThrow(()->new PokemonNotFoundException("Pokemon could not be updated"));
        pokemon.setName(pokemonDto.getName());
        pokemon.setType(pokemonDto.getType());
        Pokemon pokemonResponse =pokemonRepository.save(pokemon);
        return Mappers.mapToPokemonDto(pokemon);
    }

    @Override
    public PokemonDto deletePokemonByID(int id) {
        Pokemon pokemon=pokemonRepository.findById(id)
                .orElseThrow(()->new PokemonNotFoundException("there is no pokemon with this id "));
        if(!pokemon.getName().isEmpty()) pokemonRepository.deleteById(id);
        return Mappers.mapToPokemonDto(pokemon);
    }


}
