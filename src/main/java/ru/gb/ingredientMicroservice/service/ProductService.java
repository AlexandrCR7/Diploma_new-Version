package ru.gb.ingredientMicroservice.service;



import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Getter
public class ProductService {

    private final ProductRepository productRepository;

    public List<Ingredient> showAll(){
        return productRepository.findAll();
    }

    public Optional<Ingredient> showById(Long id){
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

//    public void saveProduct(Ingredient ingredient){
//        productRepository.save(ingredient);
//    }
//
//    public Ingredient addNewIngredient(String typeOfProduct, String category, Float weight, Float priceFor100gr){
//        Ingredient ingredient = new Ingredient();
//        ingredient.setTypeOfProduct(typeOfProduct);
//        ingredient.setCategory(category);
//        ingredient.setWeight(weight);
//        ingredient.setPriceFor100gr(priceFor100gr);
//        return ingredient;
//    }

}
