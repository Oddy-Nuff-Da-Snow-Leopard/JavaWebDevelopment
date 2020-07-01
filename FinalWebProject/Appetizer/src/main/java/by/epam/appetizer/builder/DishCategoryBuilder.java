package by.epam.appetizer.builder;

import by.epam.appetizer.entity.DishCategory;

public interface DishCategoryBuilder {

    DishCategory build();

    DishCategoryBuilder withId(int id);

    DishCategoryBuilder withCategory(String category);
}
