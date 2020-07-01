package by.epam.appetizer.builder;

import by.epam.appetizer.entity.OrderStatus;

public interface OrderStatusBuilder {

    OrderStatus build();

    OrderStatusBuilder withId(int id);

    OrderStatusBuilder withStatus(String status);
}
