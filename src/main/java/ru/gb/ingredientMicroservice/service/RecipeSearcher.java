package ru.gb.ingredientMicroservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;

import java.util.*;

@Service
@AllArgsConstructor
public class RecipeSearcher {

    private final RecipeMapper recipeMapper;

    /**
    productList - лист из ProductRequest
    recipeList - лист с рецептами
    1. Создать постмэппинг который будет через реквест боди(ProductRequest) принимать список продуктов\реквестов.
    2. Придумать метод который будет находить оптимальный рецепт из списка рецептов,
     он будет возвращать рецайп дто (Список ДТО или один ДТО)
     */

    //Создаем ТрееМЭП, где ключ это рецепт, а значение это то,
    // сколько раз мы нашли в нем тот ингредиент, который искали
    public TreeMap<RecipeDto, Integer> searchRecipe(List<String> productList, Recipe recipe){
        TreeMap<RecipeDto, Integer> recipeIntegerHashMap = new TreeMap<>(Collections.reverseOrder());
        int count = 0;
        for (int i = 0; i < productList.size(); i++){
            for (int j = 0; j < recipe.getIngredients().size(); j++) {
                if (recipe.getIngredients().get(j).getCategory().contains(productList.get(i))){
                    count++;
                    recipeIntegerHashMap.put(recipeMapper.toDto(recipe), count);
                }
            }
        }
        return recipeIntegerHashMap;
    }
}
