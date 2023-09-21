package com.pokemonreview.api.models;

import com.pokemonreview.api.dto.pokemonDtos.PokemonDto;
import com.pokemonreview.api.dto.pokemonDtos.ReviewPokemonDto;

public class Mappers {
    public static PokemonDto mapToPokemonDto(Pokemon pokemon){
        PokemonDto pokemonDto =new PokemonDto();
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setType(pokemon.getType());
        return pokemonDto;
    }
    public static Pokemon mapToPokemonEntity(PokemonDto pokemonDto){
        Pokemon pokemon =new Pokemon();
        pokemon.setId(pokemonDto.getId());
        pokemon.setName(pokemonDto.getName());
        return pokemon;
    }
    public static Pokemon mapToPokemonResponse(Pokemon pokemon){
        Pokemon responsePokemon =new Pokemon();
        responsePokemon.setId(pokemon.getId());
        responsePokemon.setName(pokemon.getName());
        responsePokemon.setType(pokemon.getType());
        return responsePokemon;
    }

    public static Review mapToReviewEntity(ReviewPokemonDto reviewDto){
      /*  Review review=new Review();
        review.setId(reviewDto.getId());
        review.setTitle(reviewDto.getTitle());
        review.setContent(reviewDto.getContent());
        review.setStart(reviewDto.getStart());
        review.setPokemon(reviewDto.getPokemon());
        return review;*/
        return null;
    }
    public static ReviewPokemonDto mapToReviewDto(Review review){
        /*ReviewDto reviewDto =new ReviewDto();
        reviewDto.setId(review.getId());
        reviewDto.setTitle(review.getTitle());
        reviewDto.setContent(review.getContent());
        reviewDto.setStart(review.getStart());
        reviewDto.setPokemon(Mappers.mapToPokemonResponse(review.getPokemon()));
        return reviewDto;*/
        return null;
    }


}
