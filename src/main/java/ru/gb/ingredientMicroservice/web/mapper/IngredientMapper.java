package ru.gb.ingredientMicroservice.web.mapper;

import org.mapstruct.Mapper;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.web.dto.IngredientDto;

@Mapper(componentModel = "spring")
public interface IngredientMapper extends Mappable<Ingredient, IngredientDto>{

}
