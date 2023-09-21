package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.pokemonDtos.PokemonDto;
import com.pokemonreview.api.dto.pokemonDtos.PokemonResponse;
import com.pokemonreview.api.dto.pokemonDtos.PokemonSourceDto;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;
    @Override
    public PokemonDto createPokemon(PokemonSourceDto pokemonSource) {
        Pokemon newPokemon=pokemonRepository.save(modelMapper.map(pokemonSource,Pokemon.class));
        return modelMapper.map(newPokemon,PokemonDto.class);
    }

    @Override
    public PokemonResponse getAllPokemon(int pageNo,int pageSize) {   //getting data with pagination
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemons =pokemons.getContent();
        List<PokemonDto> content = listOfPokemons.stream()
                .map(pokemon -> modelMapper.map(pokemon, PokemonDto.class)).collect(Collectors.toList());
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
    return modelMapper.map(pokemon, PokemonDto.class);
    }

    @Override
    public PokemonDto updatePokemon(int id, PokemonSourceDto pokemonSource) {
        Pokemon testpokemon =pokemonRepository.findById(id)
                .orElseThrow(()->new PokemonNotFoundException("Pokemon could not be updated"));
        testpokemon.setName(pokemonSource.getName());
        testpokemon.setType(pokemonSource.getType());
        Pokemon pokemonResponse =pokemonRepository.save(testpokemon);
        return modelMapper.map(pokemonResponse, PokemonDto.class);
    }

    @Override
    public PokemonDto deletePokemonByID(int id) {
        Pokemon pokemon=pokemonRepository.findById(id)
                .orElseThrow(()->new PokemonNotFoundException("there is no pokemon with this id "));
        if(!pokemon.getName().isEmpty()) pokemonRepository.deleteById(id);
        return modelMapper.map(pokemon, PokemonDto.class);
    }


}
