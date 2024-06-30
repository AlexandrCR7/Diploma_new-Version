package ru.gb.ingredientMicroservice.model.products;

import jakarta.persistence.*;
import lombok.Data;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "TYPE")
    private String typeOfProduct;
    @Column(nullable = false, name = "PRODUCTNAME")
    private String category;
    @Column(nullable = false, name = "WEIGHT")
    private Float weight;
    @Column(nullable = false, name = "PRICEFOR100GR")
    private Float priceFor100gr;

//    @ManyToMany(mappedBy = "ingredients")
//    private Set<Recipe> ingredientSet; //probably we need return hashSet
}
