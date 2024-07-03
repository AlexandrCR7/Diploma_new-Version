create table ingredients (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
type VARCHAR(50) NOT NULL,
category VARCHAR(50) NOT NULL,
weight INT NOT NULL,
price FLOAT NOT NULL
);

create table recipes (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
recipe VARCHAR(300) NOT NULL,
name VARCHAR(300) NOT NULL,
calories INT NOT NULL,
protein INT NOT NULL,
fat INT NOT NULL,
carbohydrates INT NOT NULL,
ingredient_id INT NOT NULL,
FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);

CREATE TABLE recipe_ingredient
(
    recipe_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    PRIMARY KEY (recipe_id, ingredient_id),
    FOREIGN KEY (recipe_id) REFERENCES recipes (id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);
