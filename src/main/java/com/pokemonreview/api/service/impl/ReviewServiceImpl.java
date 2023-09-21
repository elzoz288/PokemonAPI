package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.reviewDtos.ReviewDto;
import com.pokemonreview.api.dto.reviewDtos.ReviewSourceDto;
import com.pokemonreview.api.exception.PokemonNotFoundException;
import com.pokemonreview.api.exception.ReviewNotFoundException;
import com.pokemonreview.api.models.Pokemon;
import com.pokemonreview.api.models.Review;
import com.pokemonreview.api.repository.PokemonRepository;
import com.pokemonreview.api.repository.ReviewRepository;
import com.pokemonreview.api.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final PokemonRepository pokemonRepository;
    private final ReviewRepository reviewRepository;
    private final ModelMapper  modelMapper;

    @Override
    public ReviewDto addReview(ReviewSourceDto reviewSource, int pokemonID) {
        Review review=modelMapper.map(reviewSource,Review.class);
        Pokemon pokemon=pokemonRepository.findById(pokemonID)
                         .orElseThrow(()->new PokemonNotFoundException("Pokemon with associated review not found"));
        review.setPokemon(pokemon);
        return modelMapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public ReviewDto updateReview(ReviewSourceDto reviewSource, int reviewId, int pokemonId) {
       Pokemon pokemon =pokemonRepository.findById(pokemonId).orElseThrow(()->new PokemonNotFoundException("Pokemon with associated review not found"));
       Review review=reviewRepository.findById(reviewId).orElseThrow(()->new ReviewNotFoundException("Review with associated pokemon not found "));
       if (review.getPokemon().getId()!= pokemonId) throw new ReviewNotFoundException("This review dose not belong to the pokemon");

       review.setTitle(reviewSource.getTitle());
       review.setContent(reviewSource.getContent());
       review.setStart(reviewSource.getStart());

       Review updatedView=reviewRepository.save(review);

       return modelMapper.map(review,ReviewDto.class);
    }

    @Override
    public ReviewDto deleteReview(int reviewId) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(()->new ReviewNotFoundException("the review with this id could not be found to delete it"));
        if (!review.getTitle().isEmpty()) reviewRepository.deleteById(reviewId);
        return modelMapper.map(review, ReviewDto.class);
    }


    @Override
    public List<ReviewDto> getAll() {

        return reviewRepository.findAll().stream().map(review -> modelMapper.map(review,ReviewDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDto> getByPokemonID(int pokemonID) {
        return reviewRepository.findByPokemonId(pokemonID).stream()
                .map(review -> modelMapper.map(review,ReviewDto.class)).collect(Collectors.toList());
    }
    @Override
    public ReviewDto getByReviewId(int reviewId) {
       Review review=reviewRepository.findById(reviewId)
               .orElseThrow(()->new ReviewNotFoundException("Review could not be found by this id"));
       return modelMapper.map(review, ReviewDto.class);
    }


}
