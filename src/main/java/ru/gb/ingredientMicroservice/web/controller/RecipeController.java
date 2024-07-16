package ru.gb.ingredientMicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.service.RecipeService;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;
import ru.gb.ingredientMicroservice.web.request.IngredientRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor //аннотация только для финальных полей класса
@RequestMapping("/recipes")
public class RecipeController {



    private final RecipeService recipeService;
    private final RecipeMapper recipeMapper;

    @GetMapping
    public List<RecipeDto> showAll(){
        return recipeMapper.toDto(recipeService.showAll());
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id){
        recipeService.deleteById(id);
    }

    @GetMapping("/{id}")
    public RecipeDto showRecipeById(@PathVariable Long id){
        return recipeMapper.toDto(recipeService.showById(id));
    }

    @PostMapping("/createRecipe")
    public RecipeDto createProductAction(@RequestBody RecipeDto recipe){
        return recipeMapper.toDto(recipeService.saveProduct(recipeMapper.toEntity(recipe)));
    }

    @PostMapping("/generate")
    public List<RecipeDto> generateRecipe(@RequestBody List<IngredientRequest> ingredientRequest){
        return recipeMapper.toDto(recipeService.generateRecipes(ingredientRequest));
    }

}
