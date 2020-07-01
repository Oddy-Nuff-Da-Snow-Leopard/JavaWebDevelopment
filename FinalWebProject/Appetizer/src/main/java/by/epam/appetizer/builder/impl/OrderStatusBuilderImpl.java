package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.OrderStatusBuilder;
import by.epam.appetizer.entity.OrderStatus;

public class OrderStatusBuilderImpl implements OrderStatusBuilder {

    private int id;
    private String status;

    public OrderStatus build() {
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(id);
        orderStatus.setStatus(status);
        return orderStatus;
    }

    public OrderStatusBuilderImpl withId(int id) {
        this.id = id;
        return this;
    }

    public OrderStatusBuilderImpl withStatus(String status) {
        this.status = status;
        return this;
    }
}
