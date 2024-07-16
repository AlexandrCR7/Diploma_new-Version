package ru.gb.ingredientMicroservice.service;



import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.ingredientMicroservice.model.exception.IngredientNotFoundException;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.repositories.IngredientRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    /**
     * Стандартный метод CRUD
     * @return возвращает список ингредиентов
     */
    public List<Ingredient> showAll(){
        return ingredientRepository.findAll();
    }

    /**
     * Стандартный метод CRUD
     * @param id - принимает на вход id искомого ингредиента
     * @return - возвращает искомый ингредиент
     * При отсутствии в репозитории ингредиента по запрашиваемому id обрабатывает ошибку
     */
    public Ingredient showById(Long id){
        return ingredientRepository.findById(id).orElseThrow(()->
                new IngredientNotFoundException("Ingredient by %d not found".formatted(id)));
    }

    /**
     * Стандартный метод CRUD
     * @param id - принимает на вход id ингредиента, который необходимо удалить
     */

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }


    /**
     * Стандартный метод CRUD
     * Сохраняет ингредиент в репозитории
     */

    public void saveProduct(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    /**
     * Стандартный метод CRUD для создания нового объекта
     * @param typeOfProduct - тип продукта
     * @param category - категория
     * @param weight - вес
     * @param priceFor100gr - цена
     * @return - возвращает созданный ингредиент
     */

    public Ingredient addNewIngredient(String typeOfProduct, String category, Float weight, Float priceFor100gr){
        Ingredient ingredient = new Ingredient();
        ingredient.setType(typeOfProduct);
        ingredient.setCategory(category);
        ingredient.setWeight(weight);
        ingredient.setPrice(priceFor100gr);
        return ingredient;
    }

}
