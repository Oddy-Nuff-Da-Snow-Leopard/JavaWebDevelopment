package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.DishBuilder;
import by.epam.appetizer.entity.Dish;

public class DishBuilderImpl implements DishBuilder {

    private int id;
    private int categoryId;
    private String name;
    private String description;
    private double price;
    private String imagePath;

    public Dish build() {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setCategoryId(categoryId);
        dish.setName(name);
        dish.setDescription(description);
        dish.setPrice(price);
        dish.setImagePath(imagePath);
        return dish;
    }

    public DishBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public DishBuilder withCategoryId(int categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public DishBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public DishBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public DishBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public DishBuilder withImagePath(String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

}
