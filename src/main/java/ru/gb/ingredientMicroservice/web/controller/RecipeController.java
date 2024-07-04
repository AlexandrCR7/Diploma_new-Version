package ru.gb.ingredientMicroservice.web.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.RecipeRepository;
import ru.gb.ingredientMicroservice.service.DBFileWriter;
import ru.gb.ingredientMicroservice.service.RecipeService;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor //аннотация только для финальных полей класса
@RequestMapping("/recipes")
public class RecipeController {

    //Создать постмэппинг который будет через реквест боди(ProductRequest) принимать список продукт реквестов, придумать метод который
    // будет находить оптимальный рецепт из списка рецептов, он будет возвращать рецайп дто (Список ДТО или один ДТО)

    private final RecipeService recipeService;
    private final DBFileWriter dbFileWriter;
    private final RecipeMapper recipeMapper;

    @GetMapping
    public List<RecipeDto> showAll(){
        return recipeMapper.toDto(recipeService.showAllChecks());
    }

    @DeleteMapping("/{id}")// change annotation @Delete....
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteById(id);
    }

    @GetMapping("/{id}")//only id
    public Optional<Recipe> showRecipeById(@PathVariable Long id){
        return recipeService.showById(id);
    }

//    @GetMapping("/createRecipe")
//    public String createRecipe(Model model){
//        model.addAttribute("createProduct", recipeRepository.findAll());
//        return "Check has been created";
//    }

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
