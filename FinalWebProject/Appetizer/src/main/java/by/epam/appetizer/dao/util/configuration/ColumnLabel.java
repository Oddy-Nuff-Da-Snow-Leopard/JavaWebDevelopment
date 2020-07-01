package by.epam.appetizer.dao.util.configuration;

public final class ColumnLabel {

    private ColumnLabel() {
    }

    // Users table columns
    public static final String USER_ID = "userId";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String ROLE_ID = "roleId";

    // UsersData table columns
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String GENDER = "gender";
    public static final String USERNAME = "username";
    public static final String PHONE_NUMBER = "phoneNumber";

    // Dishes table columns
    public static final String DISH_ID = "dishId";
    //public static final String CATEGORY_ID = "categoryId";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String IMAGE_PATH = "imagePath";

    // DishesCategories table columns
    public static final String CATEGORY_ID = "categoryId";
    public static final String CATEGORY = "category";

    // CartItems table columns
    public static final String CART_ITEM_ID = "cartItemId";
    public static final String USER_CART_ID = "userCartId";
//    public static final String DISH_ID = "dishId";
    public static final String QUANTITY = "quantity";

    // Orders table columns
    public static final String ORDER_ID = "orderId";
//    public static final String USER_CART_ID = "userCartId";
    public static final String STATUS_ID = "statusId";
    public static final String TOTAL_PRICE = "totalPrice";
    public static final String DATE = "creationDate";
    public static final String COMMENT = "commentary";
}
