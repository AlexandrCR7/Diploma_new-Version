package ru.gb.ingredientMicroservice.service;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.RecipeRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
public class RecipeService {

    private final RecipeRepository recipeRepository;


    public List<Recipe> showAllChecks() {
        return recipeRepository.findAll();
    }

    public Optional<Recipe> showById(Long id) {
        return recipeRepository.findById(id);
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }


    public Recipe saveProduct(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipe;
    }


    public Recipe addNewIngredient(String newRecipe, String name, Integer calories,
                                   Integer protein, Integer fat,
                                   Integer carbohydrates, Integer ingredient_id) {
        Recipe recipe = new Recipe();
        recipe.setRecipe(newRecipe);
        recipe.setName(name);
        recipe.setCalories(calories);
        recipe.setProtein(protein);
        recipe.setFat(fat);
        recipe.setCarbohydrates(carbohydrates);
        recipe.setIngredient_id(ingredient_id);
        return recipe;
    }
}

