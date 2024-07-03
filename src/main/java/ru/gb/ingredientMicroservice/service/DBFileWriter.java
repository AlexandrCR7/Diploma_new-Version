package ru.gb.ingredientMicroservice.service;

import org.springframework.integration.annotation.MessagingGateway;

import java.io.FileWriter;
import java.io.IOException;

@MessagingGateway
public class DBFileWriter {
    public void writeToData(String productType, String productName, Float weight, Float priceFor100gr) {
        try (java.io.FileWriter fileWriter = new java.io.FileWriter("C:\\Deals\\WorkBook\\java\\SpringTasks\\" +
                "GB_Diploma\\ingredientMicroservice\\src\\main\\resources\\data.sql", true)) {
            fileWriter.append("insert into ingredients (type, category, weight, price)" +
                    "\n" + "values " + "('" + productType + "', " + "'" + productName + "', " + weight + ", " + " '" + priceFor100gr + "'" + ");" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void RecipesFileWriter(String newRecipe, String name, Integer calories,
                                  Integer protein, Integer fat,
                                  Integer carbohydrates, Integer ingredient_id) {
        try (FileWriter fileWriter = new FileWriter("C:\\Deals\\WorkBook\\java\\SpringTasks\\" +
                "GB_Diploma\\ingredientMicroservice\\src\\main\\resources\\data.sql", true)) {
            fileWriter.append("insert into recipes (recipe, name, calories, protein, fat, carbohydrates, ingredient_id)" +
                    "\n" + "values " + "('" + newRecipe + "', " + "'" + name + "', " + calories + ", " + protein
                    + ", " +  fat + ", "  + carbohydrates + ", " + ingredient_id + ");" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


