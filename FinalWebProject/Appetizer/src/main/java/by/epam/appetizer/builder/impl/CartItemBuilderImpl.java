package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.CartItemBuilder;
import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Dish;

public class CartItemBuilderImpl implements CartItemBuilder {

    private int id;
    private int userCartId;
    private Dish dish;
    private int quantity;

    public CartItem build() {
        CartItem cartItem = new CartItem();
        cartItem.setId(id);
        cartItem.setUserCartId(userCartId);
        cartItem.setDish(dish);
        cartItem.setQuantity(quantity);
        return cartItem;
    }

    public CartItemBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CartItemBuilder withUserCartId(int userCartId) {
        this.userCartId = userCartId;
        return this;
    }

    public CartItemBuilder withDish(Dish dish) {
        this.dish = dish;
        return this;
    }

    public CartItemBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }
}
