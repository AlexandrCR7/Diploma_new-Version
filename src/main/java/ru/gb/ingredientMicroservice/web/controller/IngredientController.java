package ru.gb.ingredientMicroservice.web.controller;

import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.service.DBFileWriter;
import ru.gb.ingredientMicroservice.service.IngredientService;
import ru.gb.ingredientMicroservice.web.dto.IngredientDto;
import ru.gb.ingredientMicroservice.web.mapper.IngredientMapper;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")//задать путь для контроллера
public class IngredientController {


    private final IngredientService ingredientService;
    private final IngredientMapper ingredientMapper;
    DBFileWriter DBFileWriter;


    @GetMapping//without path
    public List<IngredientDto> showAllProducts(){
        return ingredientMapper.toDto(ingredientService.showAll());
    }

    @DeleteMapping("/delete/{id}")//deletemapping
    public String deleteProductById(@PathVariable Long id){
        ingredientService.deleteById(id);
        return "Product has been deleted";
    }

    @GetMapping("/{id}")//оставить только id
    public IngredientDto showProductById(@PathVariable Long id){
        return ingredientMapper.toDto(ingredientService.showById(id));
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model){
        model.addAttribute("CreateProduct", ingredientService.showAll());
        return "Tack has been created";
    }

    @PostMapping("/createProduct")
    public String createProductAction(@RequestBody Ingredient product, Model model){
        ingredientService.saveProduct(ingredientService.addNewIngredient(product.getType(),
                product.getCategory(),
                product.getWeight(),
                product.getPrice()));
        model.addAttribute("recipe", ingredientService.showAll());
        DBFileWriter.writeToData(product.getType(),
                product.getCategory(),
                product.getWeight(),
                product.getPrice());
        return "Product has been created";
    }
}
