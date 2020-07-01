package by.epam.appetizer.entity;

import java.util.Objects;

public class Dish extends Entity {

    private int categoryId;
    private String name;
    private String description;
    private double price;
    private String imagePath;

    public Dish() {
    }

    public Dish(int id, int categoryId, String name, String description,
            double price, String imagePath) {
        super(id);
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePath = imagePath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        Dish dish = (Dish) obj;
        return categoryId == dish.categoryId
                && Objects.equals(name, dish.name)
                && Objects.equals(description, dish.description)
                && Objects.equals(price, dish.price)
                && Objects.equals(imagePath, dish.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, categoryId, description, price, imagePath);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("categoryId=").append(categoryId).append(", ");
        str.append("name=").append(name).append(", ");
        str.append("description=").append(description).append(", ");
        str.append("price=").append(price).append(", ");
        str.append("imagePath=").append(imagePath).append("]");
        return str.toString();
    }
}
