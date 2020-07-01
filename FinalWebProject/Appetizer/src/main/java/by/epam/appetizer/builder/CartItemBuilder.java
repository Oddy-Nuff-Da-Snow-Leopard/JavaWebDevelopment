package by.epam.appetizer.builder;

import by.epam.appetizer.entity.CartItem;
import by.epam.appetizer.entity.Dish;

public interface CartItemBuilder {

    CartItem build();

    CartItemBuilder withId(int id);

    CartItemBuilder withUserCartId(int userCartId);

    CartItemBuilder withDish(Dish dish);

    CartItemBuilder withQuantity(int quantity);
}
