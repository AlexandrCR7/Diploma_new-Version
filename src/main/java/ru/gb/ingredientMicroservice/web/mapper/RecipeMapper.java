package ru.gb.ingredientMicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;

@Mapper(componentModel = "spring")
public interface RecipeMapper extends Mappable<Recipe, RecipeDto> {
}
