package ru.gb.ingredientMicroservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.gb.ingredientMicroservice.model.exception.ExceptionBody;
import ru.gb.ingredientMicroservice.model.exception.IngredientNotFoundException;
import ru.gb.ingredientMicroservice.model.exception.RecipeNotFoundException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(RecipeNotFoundException.class)
    public ResponseEntity<ExceptionBody> handleRecipeNotFoundException
            (RecipeNotFoundException recipeNotFoundException){
        return new ResponseEntity<>(new ExceptionBody(recipeNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IngredientNotFoundException.class)
    public ResponseEntity<ExceptionBody> handlerIngredientNotFoundException
            (IngredientNotFoundException ingredientNotFoundException){
        return new ResponseEntity<>(new ExceptionBody(ingredientNotFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
