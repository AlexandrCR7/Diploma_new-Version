package ru.gb.ingredientMicroservice.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import ru.gb.ingredientMicroservice.model.products.Ingredient;

import java.util.List;

public record RecipeDto(

        String recipe,
        String name,
        Integer calories,
        Integer protein,
        Integer fat,
        Integer carbohydrates,
        Integer ingredient_id,
        List<Ingredient> ingredients
) {
}
