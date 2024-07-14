package ru.gb.ingredientMicroservice.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.ingredientMicroservice.model.exception.RecipeNotFoundException;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.RecipeRepository;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;
import ru.gb.ingredientMicroservice.web.request.IngredientRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

@Service
@AllArgsConstructor
@Getter
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;


    public List<Recipe> showAll() {
        return recipeRepository.findAll();
    }

    public Recipe showById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() ->
                new RecipeNotFoundException("Recipe by %d not found".formatted(id)));
    }

    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }


    public Recipe saveProduct(Recipe recipe) {
        return recipeRepository.save(recipe);
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

    public List<Recipe> generateRecipes(List<IngredientRequest> ingredientRequests){
        return recipeRepository.findRecipesContainsIngredient(ingredientRequests
                .stream()
                .map(IngredientRequest::category)
                .toList());
    }

//    public TreeMap<RecipeDto, Integer> generateRecipes(List<IngredientRequest> ingredientRequest) {
//        List<String> ingredients = ingredientRequest.stream().map(IngredientRequest::ingredientCategory).toList();
//        List<Recipe> recipeList = recipeRepository.findRecipesContainsIngredient(ingredients); // получаем список уникальных ингредиентов из запроса
//        TreeMap<RecipeDto, Integer> recipeIntegerHashMap = new TreeMap<>(Collections.reverseOrder());
//        int count = 0;
//        for (Recipe recipe : recipeList) {
//            for (int j = 0; j < ingredients.size(); j++) {
//                for (String ingredient : ingredients)
//                    if (recipe.getIngredients().get(j).getCategory().contains(ingredient)) {
//                        count++;
//                        recipeIntegerHashMap.put(recipeMapper.toDto(recipe), count);
//                    }
//                }
//            }
//            return recipeIntegerHashMap;
//        }

}


