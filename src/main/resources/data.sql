insert into ingredient (TYPE, PRODUCTNAME, WEIGHT, PRICEFOR100GR)
values ('Белки', 'Мясо', 100.0, '20.0');
insert into ingredient (TYPE, PRODUCTNAME, WEIGHT, PRICEFOR100GR)
values ('Углеводы', 'Макароны', 100.0,  '26.0');
insert into ingredient (TYPE, PRODUCTNAME, WEIGHT, PRICEFOR100GR)
values ('Углеводы', 'Гречка', 100.0,  '30.0');
insert into ingredient (TYPE, PRODUCTNAME, WEIGHT, PRICEFOR100GR)
values ('Жиры', 'Масло сливочное', 100.0,  '40.0');
insert into recipe (recipe, name, calories, protein, fat, carbohydrates, ingredient_id)
values ('Пожарить еду 5 минут', 'Жареная еда',  40.0, 30.0, 10.0, 1);