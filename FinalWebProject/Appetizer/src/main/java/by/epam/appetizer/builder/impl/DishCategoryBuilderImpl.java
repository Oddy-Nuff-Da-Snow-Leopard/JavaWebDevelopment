package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.DishCategoryBuilder;
import by.epam.appetizer.entity.DishCategory;

public class DishCategoryBuilderImpl implements DishCategoryBuilder {

    private int id;
    private String category;

    public DishCategory build() {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setId(id);
        dishCategory.setCategory(category);
        return dishCategory;
    }

    public DishCategoryBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public DishCategoryBuilder withCategory(String category) {
        this.category = category;
        return this;
    }
}
