package by.epam.appetizer.builder;

import by.epam.appetizer.entity.Dish;

public interface DishBuilder {

    Dish build();

    DishBuilder withId(int id);

    DishBuilder withCategoryId(int categoryId);

    DishBuilder withName(String name);

    DishBuilder withDescription(String description);

    DishBuilder withPrice(double price);

    DishBuilder withImagePath(String imagePath);
}
