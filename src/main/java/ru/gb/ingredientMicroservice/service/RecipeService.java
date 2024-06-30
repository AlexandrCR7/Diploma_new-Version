package ru.gb.ingredientMicroservice.service;

import lombok.AllArgsConstructor;
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

//    public Recipe addNewIngredient(Float recipeWeight, Float recipePrice) {
//        Recipe recipe = new Recipe();
//        recipe.setCheckWeight(recipeWeight);
//        recipe.setCheckPrice(recipePrice);
//        return recipe;
//    }
}

