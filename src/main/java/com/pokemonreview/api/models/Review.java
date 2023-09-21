package com.pokemonreview.api.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String title ;
    private  String content ;
    private  int start;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "pokemon_ID")
    private Pokemon pokemon;

}
