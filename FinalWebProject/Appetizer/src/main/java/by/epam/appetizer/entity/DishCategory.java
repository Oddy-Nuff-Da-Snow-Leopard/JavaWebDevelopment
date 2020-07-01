package by.epam.appetizer.entity;

import java.util.Objects;

public class DishCategory extends Entity {

    private String category;

    public DishCategory() {
    }

    public DishCategory(int id, String category) {
        super(id);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        DishCategory dishCategory = (DishCategory) obj;
        return Objects.equals(category, dishCategory.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("category=").append(category).append("]");
        return str.toString();
    }
}
