package by.epam.appetizer.dao.util;

import by.epam.appetizer.builder.impl.*;
import by.epam.appetizer.dao.*;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.epam.appetizer.dao.util.configuration.ColumnLabel.*;
import java.sql.Date;

public final class Creator {

    private static final Creator INSTANCE = new Creator();

    private final DishDAO dishDAO = DAOFactory.getInstance().getDishDAO();

    private Creator() {
    }

    public static Creator getInstance() {
        return INSTANCE;
    }

    public User createUser(ResultSet rs) throws SQLException {
        int userId = rs.getInt(USER_ID);
        String email = rs.getString(EMAIL);
        String password = rs.getString(PASSWORD);
        int roleId = rs.getInt(ROLE_ID);
        String firstName = rs.getString(FIRST_NAME);
        String lastName = rs.getString(LAST_NAME);
        String gender = rs.getString(GENDER);
        String username = rs.getString(USERNAME);
        String phoneNumber = rs.getString(PHONE_NUMBER);
        return new UserBuilderImpl()
                .withId(userId)
                .withEmail(email)
                .withPassword(password)
                .withRoleId(roleId)
                .withFirstName(firstName)
                .withLastName(lastName)
                .withGender(gender)
                .withUsername(username)
                .withPhoneNumber(phoneNumber)
                .build();
    }

    public Dish createDish(ResultSet rs) throws SQLException {
        int dishId = rs.getInt(DISH_ID);
        int categoryId = rs.getInt(CATEGORY_ID);
        String name = rs.getString(NAME);
        String description = rs.getString(DESCRIPTION);
        double price = rs.getDouble(PRICE);
        String imagePath = rs.getString(IMAGE_PATH);
        return new DishBuilderImpl()
                .withId(dishId)
                .withCategoryId(categoryId)
                .withName(name)
                .withDescription(description)
                .withPrice(price)
                .withImagePath(imagePath)
                .build();
    }

    public DishCategory createDishCategory(ResultSet rs) throws SQLException {
        int categoryId = rs.getInt(CATEGORY_ID);
        String category = rs.getString(CATEGORY);
        return new DishCategoryBuilderImpl()
                .withId(categoryId)
                .withCategory(category)
                .build();
    }

    public CartItem createCartItem(ResultSet rs) throws SQLException, DAOException {
        int cartItemId = rs.getInt(CART_ITEM_ID);
        int userCartId = rs.getInt(USER_CART_ID);
        int dishId = rs.getInt(DISH_ID);
        int quantity = rs.getInt(QUANTITY);
        Dish dish = dishDAO.getDishById(dishId);
        return new CartItemBuilderImpl()
                .withId(cartItemId)
                .withUserCartId(userCartId)
                .withDish(dish)
                .withQuantity(quantity)
                .build();
    }

    public Order createOrder(ResultSet rs) throws SQLException, DAOException {
        int orderId = rs.getInt(ORDER_ID);
        int userCartId = rs.getInt(USER_CART_ID);
        int statusId = rs.getInt(STATUS_ID);
        double totalPrice = rs.getDouble(TOTAL_PRICE);
        Date date = rs.getDate(DATE);
        String comment = rs.getString(COMMENT);
        return new OrderBuilderImpl()
                .withId(orderId)
                .withUserCartId(userCartId)
                .withStatusId(statusId)
                .withTotalPrice(totalPrice)
                .withDate(date)
                .withComment(comment)
                .build();
    }
}
