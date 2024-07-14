package ru.gb.ingredientMicroservice.web.dto;

import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.List;

public record IngredientDto(

        String type,
        String category,
        Float weight,
        Float price,
        List<Recipe> recipe


) {
}
