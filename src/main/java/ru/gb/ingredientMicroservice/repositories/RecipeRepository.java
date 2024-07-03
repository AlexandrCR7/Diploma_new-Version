package ru.gb.ingredientMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
