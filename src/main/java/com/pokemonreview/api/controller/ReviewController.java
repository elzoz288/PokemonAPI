package com.pokemonreview.api.controller;

import com.pokemonreview.api.dto.ReviewDto;
import com.pokemonreview.api.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/PokemonReview")
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping("/getAll")
    public ResponseEntity<List<ReviewDto>>getAll(){
        return new ResponseEntity<>(reviewService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/getByPID/{pokemonId}")
    public ResponseEntity<List<ReviewDto>>getByPokemonID(@PathVariable(value = "pokemonId") int pokemonId){
        return new ResponseEntity<>(reviewService.getByPokemonID(pokemonId),HttpStatus.CREATED);
    }
    @GetMapping("/getByRID/{reviewId}")
    public ResponseEntity<ReviewDto>getById(@PathVariable(value = "reviewId") int reviewId ){
        return new ResponseEntity<>(reviewService.getByReviewId(reviewId),HttpStatus.CREATED);
    }

     @PostMapping("/addReview/{pokemonID}")
    public ResponseEntity<ReviewDto>addReview(@PathVariable(value = "pokemonID") int pokemonID,@Valid @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.addReview(reviewDto,pokemonID),HttpStatus.CREATED);
    }

    @PutMapping("/update/{reviewId}/{pokemonId}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable int reviewId,@PathVariable int pokemonId,@Valid @RequestBody ReviewDto reviewDto){
        return new ResponseEntity<>(reviewService.updateReview(reviewDto,reviewId,pokemonId),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{reviewId}")
    public ResponseEntity<ReviewDto> deleteReview(@PathVariable int reviewId){
        return new ResponseEntity<>(reviewService.deleteReview(reviewId),HttpStatus.CREATED);
    }

}
