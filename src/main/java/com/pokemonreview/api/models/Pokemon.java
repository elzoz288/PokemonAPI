package com.pokemonreview.api.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Pokemon {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private  String type ;
    @OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review>reviews;
}
