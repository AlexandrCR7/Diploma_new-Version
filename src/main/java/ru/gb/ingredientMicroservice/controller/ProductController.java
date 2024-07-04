package ru.gb.ingredientMicroservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.service.DBFileWriter;
import ru.gb.ingredientMicroservice.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")//задать путь для контроллера
public class ProductController {

    @Autowired
    private ProductService productService;
    DBFileWriter DBFileWriter;


    @GetMapping//without path
    public List<Ingredient> showAllProducts(){
        return productService.showAll();
    }

    @DeleteMapping("/delete/{id}")//deletemapping
    public String deleteProductById(@PathVariable Long id){
        productService.deleteById(id);
        return "Product has been deleted";
    }

    @GetMapping("/{id}")//оставить только id
    public Optional<Ingredient> showProductById(@PathVariable Long id){
        return productService.showById(id);
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model){
        model.addAttribute("CreateProduct", productService.showAll());
        return "Tack has been created";
    }

    @PostMapping("/createProduct")
    public String createProductAction(@RequestBody Ingredient product, Model model){
        productService.saveProduct(productService.addNewIngredient(product.getType(),
                product.getCategory(),
                product.getWeight(),
                product.getPrice()));
        model.addAttribute("recipe", productService.showAll());
        DBFileWriter.writeToData(product.getType(),
                product.getCategory(),
                product.getWeight(),
                product.getPrice());
        return "Product has been created";
    }
}
