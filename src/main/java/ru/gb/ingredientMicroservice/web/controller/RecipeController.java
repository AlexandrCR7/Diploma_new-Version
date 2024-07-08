package ru.gb.ingredientMicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.service.DBFileWriter;
import ru.gb.ingredientMicroservice.service.RecipeService;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;
import ru.gb.ingredientMicroservice.web.request.IngredientRequest;

import java.util.List;

@RestController //дает представление
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

//    @GetMapping("/createRecipe")
//    public String createRecipe(Model model){
//        model.addAttribute("createProduct", recipeService.showAll());
//        return "Check has been created";
//    }

    @PostMapping("/createRecipe")
    public RecipeDto createProductAction(@RequestBody RecipeDto recipe){
        return recipeMapper.toDto(recipeService.saveProduct(recipeMapper.toEntity(recipe)));
    }

    //Создать постмэппинг который будет через реквест боди(ProductRequest) принимать список продукт реквестов, придумать метод который
    // будет находить оптимальный рецепт из списка рецептов, он будет возвращать рецайп дто (Список ДТО или один ДТО)

    @PostMapping("/generate")
    public List<RecipeDto> generateRecipe(@RequestBody List<IngredientRequest> ingredientRequest){
        return recipeMapper.toDto(recipeService.generateRecipes(ingredientRequest));
    }

}
