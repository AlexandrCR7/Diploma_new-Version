package ru.gb.ingredientMicroservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.RecipeRepository;
import ru.gb.ingredientMicroservice.service.DBFileWriter;
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
    DBFileWriter dbFileWriter;

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
                recipe.getCarbohydrates(),
                recipe.getIngredient_id()));
        model.addAttribute("product", recipeService.showAllChecks());
        dbFileWriter.RecipesFileWriter(recipe.getRecipe(),
                recipe.getName(),
                recipe.getCalories(),
                recipe.getProtein(),
                recipe.getFat(),
                recipe.getCarbohydrates(),
                recipe.getIngredient_id());
        return "Check has been created";
    }
}
