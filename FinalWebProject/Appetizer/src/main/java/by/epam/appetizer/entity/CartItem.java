package by.epam.appetizer.entity;

import java.util.Objects;

public class CartItem extends Entity {

    private int userCartId;
    private Dish dish;
    private int quantity;
    
    public CartItem() {
    }

    public CartItem(int id, int userCartId, Dish dish, int quantity) {
        super(id);
        this.userCartId = userCartId;
        this.dish = dish;
        this.quantity = quantity;
    }

    public int getUserCartId() {
        return userCartId;
    }

    public void setUserCartId(int userCartId) {
        this.userCartId = userCartId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        CartItem orderItem = (CartItem) obj;
        return userCartId == orderItem.userCartId && dish.equals(orderItem.dish)
                && quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userCartId, dish, quantity);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("userCartId=").append(userCartId).append(", ");
        str.append("dish=").append(dish).append(", ");
        str.append("quantity=").append(quantity).append("]");
        return str.toString();
    }
}
