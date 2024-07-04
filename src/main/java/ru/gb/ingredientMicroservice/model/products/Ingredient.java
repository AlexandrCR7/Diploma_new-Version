package ru.gb.ingredientMicroservice.model.products;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.List;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "type")
    private String type;
    @Column(nullable = false, name = "category")
    private String category;
    @Column(nullable = false, name = "weight")
    private Float weight;
    @Column(nullable = false, name = "price")
    private Float price;

    @ManyToMany(mappedBy = "ingredients")
    @JsonBackReference
    private List<Recipe> recipe;

}
