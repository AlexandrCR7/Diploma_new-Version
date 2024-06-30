package ru.gb.ingredientMicroservice.model.products;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Table(name = "ingredient")
public class Product extends Ingredient{
}
