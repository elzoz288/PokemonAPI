package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
  List<ReviewDto>getAll();
  List<ReviewDto>getByPokemonID(int pokemonId);
  ReviewDto getByReviewId(int reviewId);
  ReviewDto addReview(ReviewDto reviewDto,int pokemonID);
  ReviewDto updateReview(ReviewDto reviewDto,int reviewId,int pokemonId);
  ReviewDto deleteReview(int reviewId);



}
