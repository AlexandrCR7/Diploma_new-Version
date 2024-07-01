package ru.gb.ingredientMicroservice.model.recipes;

import jakarta.persistence.*;
import lombok.Data;
import ru.gb.ingredientMicroservice.model.products.Ingredient;

import java.util.HashSet;
import java.util.Set;

@Table(name = "recipe")
@Entity
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToMany
//    @JoinTable(name = "ingredients",
//    joinColumns = @JoinColumn(name = "ingredients_id"))
    @Column(nullable = false, name = "recipe")
    private String recipe;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "calories")
    private Integer calories;
    @Column(nullable = false, name = "protein")
    private Integer protein;
    @Column(nullable = false, name = "fat")
    private Integer fat;
    @Column(nullable = false, name = "carbohydrates")
    private Integer carbohydrates;
    @Column(nullable = false, name = "ingredient_id")
    private Long ingredient_id;

//    private Set<Ingredient> ingredients = new HashSet<>();
//

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "recipe_products",
//            joinColumns = @JoinColumn(name = "checkProducts_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
//    private Set<Ingredient> ingredients;//probably we need return hashSet

}