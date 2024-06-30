package ru.gb.ingredientMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.ingredientMicroservice.model.products.Ingredient;

@Repository
public interface ProductRepository extends JpaRepository<Ingredient, Long> {
}
