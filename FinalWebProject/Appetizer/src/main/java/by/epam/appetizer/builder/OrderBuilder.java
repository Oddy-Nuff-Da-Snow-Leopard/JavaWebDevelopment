package by.epam.appetizer.builder;

import by.epam.appetizer.entity.Order;
import java.util.Date;

public interface OrderBuilder {

    Order build();

    OrderBuilder withId(int id);

    OrderBuilder withUserCartId(int userCartId);

    OrderBuilder withStatusId(int statusId);

    OrderBuilder withTotalPrice(double totalPrice);

    OrderBuilder withDate(Date date);

    OrderBuilder withComment(String comment);
}
