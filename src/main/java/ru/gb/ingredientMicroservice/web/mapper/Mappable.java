package ru.gb.ingredientMicroservice.web.mapper;

import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.List;
import java.util.Optional;

public interface Mappable<E,D> {
    D toDto(E entity);
    List<D> toDto(List<E> eList);

    E toEntity(D dto);
    List<E> toEntity(List<D> dList);

}
