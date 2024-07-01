package ru.gb.ingredientMicroservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;
import ru.gb.ingredientMicroservice.repositories.ProductRepository;
import ru.gb.ingredientMicroservice.service.FileWriter;
import ru.gb.ingredientMicroservice.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/showAll")
    public List<Ingredient> showAllProducts(){
        return productService.showAll();
    }

    @GetMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return "Product has been deleted";
    }

    @GetMapping("/showById/{id}")
    public Optional<Ingredient> showProductById(@PathVariable Long id){
        return productService.showById(id);
    }

//    @GetMapping("/CreateProduct")
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
}
