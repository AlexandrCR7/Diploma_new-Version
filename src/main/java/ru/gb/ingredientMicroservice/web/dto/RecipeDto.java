package ru.gb.ingredientMicroservice.web.dto;

import java.util.List;

public record RecipeDto(

        String recipe,
        String name,
        Integer calories,
        Integer protein,
        Integer fat,
        Integer carbohydrates,
        Integer ingredient_id,
        List<IngredientDto> ingredients
) {
}
