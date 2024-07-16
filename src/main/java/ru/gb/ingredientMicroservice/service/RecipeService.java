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


    /**
     * Стандартный метод CRUD
     * @return возвращает список рецептов
     */
    public List<Recipe> showAll() {
        return recipeRepository.findAll();
    }


    /**
     * Стандартный метод CRUD
     * @param id - принимает на вход id искомого ингредиента
     * @return - возвращает искомый рецепт
     * При отсутствии в репозитории рецепта по запрашиваемому id обрабатывает ошибку
     */
    public Recipe showById(Long id) {
        return recipeRepository.findById(id).orElseThrow(() ->
                new RecipeNotFoundException("Recipe by %d not found".formatted(id)));
    }

    /**
     * Стандартный метод CRUD
     * @param id - принимает на вход id рецепта, который необходимо удалить
     */
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    /**
     * Стандартный метод CRUD
     * Сохраняет ингредиент в репозитории
     */
    public Recipe saveProduct(Recipe recipe) {
        return recipeRepository.save(recipe);
    }


    /**
     * Стандартный метод CRUD для создания нового объекта
     * @param newRecipe - текстовое описание
     * @param name - имя рецепта
     * @param calories - калории
     * @param protein - кол-во белка
     * @param fat - кол-во жира
     * @param carbohydrates - кол-во углеводов
     * @param ingredient_id - внешний ключ
     * @return - возвращает новый созданный рецепт
     */
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


    /**
     * Метод выбирает все рецепты, в которых содержаться
     * запрашиваемые ингредиенты
     * @param ingredientRequests - принимает лист ингредиентов
     * @return - возвращает лист рецептов
     */
    public List<Recipe> generateRecipes(List<IngredientRequest> ingredientRequests){
        return recipeRepository.findRecipesContainsIngredient(ingredientRequests
                .stream()
                .map(IngredientRequest::category)
                .toList());
    }
}


