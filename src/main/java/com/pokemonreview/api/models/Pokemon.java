package com.pokemonreview.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pokemon {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name ;
    private  String type ;
    //@JsonManagedReference
    @OneToMany(mappedBy = "pokemon",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review>reviews;
}
