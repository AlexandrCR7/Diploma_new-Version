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

    public List<Ingredient> showAll(){
        return ingredientRepository.findAll();
    }

    public Ingredient showById(Long id){
        return ingredientRepository.findById(id).orElseThrow(()->
                new IngredientNotFoundException("Ingredient by %d not found".formatted(id)));
    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }

    public void saveProduct(Ingredient ingredient){
        ingredientRepository.save(ingredient);
    }

    public Ingredient addNewIngredient(String typeOfProduct, String category, Float weight, Float priceFor100gr){
        Ingredient ingredient = new Ingredient();
        ingredient.setType(typeOfProduct);
        ingredient.setCategory(category);
        ingredient.setWeight(weight);
        ingredient.setPrice(priceFor100gr);
        return ingredient;
    }

}
