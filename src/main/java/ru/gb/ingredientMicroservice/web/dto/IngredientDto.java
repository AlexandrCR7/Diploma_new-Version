package ru.gb.ingredientMicroservice.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.List;

public record IngredientDto(

        String type,
        String category,
        Float weight,
        Float price,
        List<Recipe> recipe //Ошибка похожая на циклическую зависимость
) {
}
