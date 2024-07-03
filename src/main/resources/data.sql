insert into ingredients (type, category, weight, price)
values ('Белки', 'Мясо', 100.0, '20.0');
insert into ingredients (type, category, weight, price)
values ('Углеводы', 'Макароны', 100.0,  '26.0');
insert into ingredients (type, category, weight, price)
values ('Углеводы', 'Гречка', 100.0,  '30.0');
insert into ingredients (type, category, weight, price)
values ('Жиры', 'Масло сливочное', 100.0,  '40.0');
insert into recipes (recipe, name, calories, protein, fat, carbohydrates, ingredient_id)
values ('Пожарить еду 5 минут', 'Жареная еда',  40.0, 30.0, 10.0, 10.0, 1);
insert into recipe_ingredient (recipe_id, ingredient_id)
values (1, 1), (1, 2), (1, 3);
insert into recipes (recipe, name, calories, protein, fat, carbohydrates, ingredient_id)
values ('Отварить сосиску 2 минуты', 'Вареная сосиска', 175, 11, 15, 7, 1);
insert into recipes (recipe, name, calories, protein, fat, carbohydrates, ingredient_id)
values ('Отварить сосиску 2 минуты', 'Вареная сосиска', 175, 11, 15, 7, 1);
insert into ingredient (type, productName, weight, priceFor100gr)
values ('Клетчатка', 'Мясо', 100.0,  '220.0');
