package ru.gb.ingredientMicroservice.model.products;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Component
@Table(name = "ingredient")
public class Product extends Ingredient{
}
