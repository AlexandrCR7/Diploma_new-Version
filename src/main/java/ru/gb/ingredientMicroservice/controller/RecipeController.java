package ru.gb.ingredientMicroservice.controller;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.RecipeRepository;
import ru.gb.ingredientMicroservice.service.RecipeService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
    @Autowired
    private RecipeRepository recipeRepository;

    @GetMapping
    public List<Recipe> showAll(){
        return recipeService.showAllChecks();
    }

    @DeleteMapping("/deleteRecipe/{id}")// change annotation @Delete....
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteById(id);
    }

    @GetMapping("/{id}")//only id
    public Optional<Recipe> showRecipeById(@PathVariable Long id){
        return recipeService.showById(id);
    }

    @GetMapping("/createRecipe")
    public String createRecipe(Model model){
        model.addAttribute("createProduct", recipeRepository.findAll());
        return "Check has been created";
    }

    @PostMapping("/createRecipe")
    public String createProductAction(@RequestBody Recipe recipe, Model model){
        recipeService.saveProduct(recipeService.addNewIngredient(recipe.getRecipe(),
                recipe.getName(),
                recipe.getCalories(),
                recipe.getProtein(),
                recipe.getFat(),
                recipe.getCarbohydrates()));
        model.addAttribute("product", recipeService.showAllChecks());
        return "Check has been created";
    }

//
//        @GetMapping("/CreateProduct")
//    public String createProduct(Model model){
//        model.addAttribute("CreateProduct", productRepository.findAll());
//        return "CreateTask";
//    }
//
//    @PostMapping("/CreateProduct")
//    public String createProductAction(@RequestBody Ingredient product, Model model){
//        productService.saveProduct(productService.addNewIngredient(product.getTypeOfProduct(),
//                product.getCategory(),
//                product.getWeight(),
//                product.getPriceFor100gr()));
//        model.addAttribute("product", productService.showAll());
//        fileWriter.writeToData(product.getTypeOfProduct(),
//                product.getCategory(),
//                product.getWeight(),
//                product.getPriceFor100gr());
//        return "Product has been created";
//    }

//    @PostMapping("/checkProduct/{recipeId}/ingredients/{ingId}")
//    public Recipe addIngredientToRecipe(@PathVariable Long recipeId, @PathVariable Long ingId){
//        Recipe recipe = recipeService.showById(recipeId).get();
//        Ingredient ingredient = productService.showById(ingId).get();
//        recipe.getIngredients().add(ingredient);
//        return recipeService.saveProduct(recipe);
//    }
}
