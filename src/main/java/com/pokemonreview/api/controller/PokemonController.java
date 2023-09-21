package com.pokemonreview.api.controller;

import com.pokemonreview.api.dto.pokemonDtos.PokemonDto;
import com.pokemonreview.api.dto.pokemonDtos.PokemonResponse;
import com.pokemonreview.api.dto.pokemonDtos.PokemonSourceDto;
import com.pokemonreview.api.service.PokemonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PokemonController {

    private final PokemonService pokemonService;

    @GetMapping("/getAll")
    public ResponseEntity<PokemonResponse> getAllPokemon(
            @RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize
    ) { return new ResponseEntity<>(pokemonService.getAllPokemon(pageNo,pageSize), HttpStatus.OK); }

    @GetMapping("/find/{id}")
    public PokemonDto getByID(@PathVariable int id){
        return pokemonService.getByID(id);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> addPockemon(@Valid @RequestBody PokemonSourceDto pokemonSource){
        return new ResponseEntity<>(pokemonService.createPokemon(pokemonSource), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PokemonDto>updatePockemon(@PathVariable int id,@Valid @RequestBody PokemonSourceDto pokemonSource){
     return new ResponseEntity<>(pokemonService.updatePokemon(id,pokemonSource),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PokemonDto> deletePockemon(@PathVariable int id){
        return new ResponseEntity<>(pokemonService.deletePokemonByID(id),HttpStatus.CREATED);
    }
}
