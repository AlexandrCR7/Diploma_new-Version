package ru.gb.ingredientMicroservice.web.dto;

public record IngredientDto(
        String type,
        String category,
        Float weight,
        Float price
) {
}
