package by.epam.appetizer.builder.impl;

import by.epam.appetizer.builder.OrderBuilder;
import by.epam.appetizer.entity.Order;
import java.util.Date;

public class OrderBuilderImpl implements OrderBuilder {

    private int id;
    private int userCartId;
    private int statusId;
    private double totalPrice;
    private Date date;
    private String comment;

    public Order build() {
        Order order = new Order();
        order.setId(id);
        order.setUserCartId(userCartId);
        order.setStatusId(statusId);
        order.setTotalPrice(totalPrice);
        order.setDate(date);
        order.setComment(comment);
        return order;
    }

    public OrderBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public OrderBuilder withUserCartId(int userCartId) {
        this.userCartId = userCartId;
        return this;
    }

    public OrderBuilder withStatusId(int statusId) {
        this.statusId = statusId;
        return this;
    }

    public OrderBuilder withTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public OrderBuilder withDate(Date date) {
        this.date = date;
        return this;
    }

    public OrderBuilder withComment(String comment) {
        this.comment = comment;
        return this;
    }
}
