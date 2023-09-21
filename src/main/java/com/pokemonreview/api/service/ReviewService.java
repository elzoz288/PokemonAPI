package com.pokemonreview.api.service;

import com.pokemonreview.api.dto.reviewDtos.ReviewDto;
import com.pokemonreview.api.dto.reviewDtos.ReviewSourceDto;

import java.util.List;

public interface ReviewService {
  List<ReviewDto>getAll();
  List<ReviewDto>getByPokemonID(int pokemonId);
  ReviewDto getByReviewId(int reviewId);
  ReviewDto addReview(ReviewSourceDto reviewSource, int pokemonID);
  ReviewDto updateReview(ReviewSourceDto reviewSource, int reviewId, int pokemonId);
  ReviewDto deleteReview(int reviewId);



}
