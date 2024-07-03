package ru.gb.ingredientMicroservice.service;

import org.springframework.integration.annotation.MessagingGateway;

import java.io.IOException;

@MessagingGateway
public class ProductFileWriter {
    public void writeToData(String productType, String productName, Float weight, Float priceFor100gr){
        try (java.io.FileWriter fileWriter = new java.io.FileWriter("C:\\Deals\\WorkBook\\java\\SpringTasks\\" +
                "GB_Diploma\\ingredientMicroservice\\src\\main\\resources\\data.sql", true)){
            fileWriter.append("insert into ingredient (TYPE, PRODUCTNAME, WEIGHT, PRICEFOR100GR)" +
                    "\n" + "values " + "('" + productType + "', " + "'" + productName + "', " + weight + ", " + " '" + priceFor100gr + "'" + ");" + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
