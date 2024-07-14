package ru.gb.ingredientMicroservice.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.service.RecipeService;
import ru.gb.ingredientMicroservice.web.dto.RecipeDto;
import ru.gb.ingredientMicroservice.web.mapper.RecipeMapper;
import ru.gb.ingredientMicroservice.web.request.IngredientRequest;

import java.util.List;
import java.util.TreeMap;

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

//    @PostMapping("/generate")
//    public TreeMap<RecipeDto, Integer> generateRecipe(@RequestBody List<IngredientRequest> ingredientRequest){
//        return recipeService.generateRecipes(ingredientRequest);
//    }

    /**
    Если откатим мои изменения и вернем обычный метод
     */

    @PostMapping("/generate")
    public List<RecipeDto> generateRecipe(@RequestBody List<IngredientRequest> ingredientRequest){
        System.out.println("Получен зарос " + ingredientRequest);
        return recipeMapper.toDto(recipeService.generateRecipes(ingredientRequest));
    }

}
