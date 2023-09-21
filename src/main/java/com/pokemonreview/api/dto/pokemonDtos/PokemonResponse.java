package com.pokemonreview.api.dto.pokemonDtos;
import com.pokemonreview.api.dto.pokemonDtos.PokemonDto;
import lombok.Data;
import java.util.List;
@Data
public class PokemonResponse {
    private List<PokemonDto> content;
    private int pageNo;
    private int pageSize;
    private long totalElements ;
    private int totalPages;
    private Boolean last;
}
