package ru.gb.ingredientMicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.gb.ingredientMicroservice.model.products.Ingredient;
import ru.gb.ingredientMicroservice.model.recipes.Recipe;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    /*
    Метод использует аннотацию @Query для определения собственного запроса к базе данных.
    Запрос выбирает все рецепты
    (r), которые содержат ингредиенты (i) из указанных категорий ингредиентов (productCategories).
     */
    @Query("SELECT DISTINCT r FROM Recipe r " + //DISTINCT - исключает дублирование
            "JOIN r.ingredients i " +
            "WHERE i.category IN :productCategories")
    List<Recipe> findRecipesContainsIngredient(@Param("ingredientCategories") List<String> ingredientCategories);
}
