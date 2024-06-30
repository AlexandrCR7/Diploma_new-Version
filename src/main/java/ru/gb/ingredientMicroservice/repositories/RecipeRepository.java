package ru.gb.ingredientMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
