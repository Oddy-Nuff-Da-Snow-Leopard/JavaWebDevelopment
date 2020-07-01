package by.epam.appetizer.dao.configuration;

public final class SQLQuery {

    private SQLQuery() {
    }

    public static final String SELECT_USER_ID_BY_EMAIL = "{call select_user_id_by_email(?, ?)}";

    public static final String SELECT_USER_BY_USER_ID = "SELECT u1.userId, email, password, roleId,"
            + "firstName, lastName, gender, username, phoneNumber"
            + " FROM Users u1 INNER JOIN UsersData u2"
            + " ON u1.userId = u2.userId"
            + " WHERE u1.userId = ?";

    public static final String SELECT_USER_BY_EMAIL = "SELECT u1.userId, email, password, roleId,"
            + " firstName, lastName, gender, username, phoneNumber"
            + " FROM Users u1 INNER JOIN UsersData u2"
            + " ON u1.userId = u2.userId"
            + " WHERE u1.email = ?";

    //    public static final String INSERT_USER = "INSERT INTO Users (email, password)"
//            + " VALUES(?, ?)";
    public static final String INSERT_USER = "{call insert_user(?, ?, ?)}";

    //    public static final String INSERT_USER_DATA = "INSERT INTO UsersData(firstName,"
//            + " lastName, gender, username, phoneNumber) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_USER_DATA = "{call insert_user_data(?, ?, ?, ?, ?)}";

    public static final String INSERT_TOKEN = "INSERT INTO Tokens (hash, creationDate, userId)"
            + " VALUES(?, ?, ?)";

    public static final String SELECT_USER_ID_BY_TOKEN_HASH = "{call select_token_by_hash(?)}";

    public static final String INSERT_USER_CART = "{call insert_user_cart(?, ?)}";
    public static final String INSERT_CART_ITEM = "{call insert_cart_item(?, ?)}";

    public static final String INSERT_ORDER = "{call insert_order(?, ?, ?)}";

    public static final String DELETE_CART_ITEM_BY_CART_ITEM_ID = "{call delete_cart_item_by_cart_item_id(?)}";

    public static final String UPDATE_CART_ITEM_QUANTITY = "UPDATE CartItems SET quantity = ?"
            + " WHERE cartItemId = ?";

    public static final String SELECT_ALL_FROM_DISHES_CATEGORIES = "SELECT * FROM DishesCategories";
    public static final String SELECT_ALL_FROM_DISHES = "SELECT * FROM Dishes";
    public static final String SELECT_CART_ITEM_BY_CART_ITEM_ID = "SELECT * FROM CartItems WHERE cartItemId = ?";
    public static final String SELECT_CART_ITEM_BY_USER_CART_ID = "SELECT * FROM CartItems WHERE userCartId = ?";

    public static final String SELECT_CART_ITEM_BY_USER_ID = "SELECT * FROM CartItems c"
            + " INNER JOIN UsersCarts u"
            + " ON c.userCartId = u.userCartId"
            + " WHERE userId = ?";

    public static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM Orders o"
            + " INNER JOIN UsersCarts u"
            + " ON o.userCartId = u.userCartId"
            + " WHERE u.userId = ? ORDER BY creationDate DESC";

    public static final String SELECT_ORDER_BY_STATUS_ID = "SELECT * FROM Orders"
            + " WHERE statusId = ?";

    public static final String SELECT_ORDER_BY_ORDER_ID = "SELECT * FROM Orders WHERE orderId = ?";

    public static final String SELECT_USER_BY_ORDER_ID = "SELECT u.userId, email,"
            + " password, roleId, firstName, lastName, gender, username, phoneNumber"
            + " FROM Orders o INNER JOIN UsersCarts us"
            + " ON o.userCartId = us.userCartId INNER JOIN Users u"
            + " ON us.userId = u.userId INNER JOIN UsersData ud"
            + " ON u.userId = ud.userId"
            + " WHERE orderId = ?";

    public static final String SELECT_CART_ITEM_BY_ORDER_ID = "SELECT cartItemId,"
            + " ci.userCartId, dishId, quantity FROM Orders o"
            + " INNER JOIN CartItems ci"
            + " ON o.userCartId = ci.userCartId"
            + " WHERE orderId = ?";

    public static final String SELECT_DISH_BY_DISH_ID = "SELECT * FROM Dishes WHERE dishId = ?";

    public static final String UPDATE_ORDER_SET_STATUS_AWAITING_PAYMENT
            = "{call UPDATE_ORDER_SET_STATUS_AWAITING_PAYMENT(?, ?)}";

    public static final String UPDATE_ORDER_SET_STATUS_CANCELLED
            = "{call UPDATE_ORDER_SET_STATUS_CANCELLED(?, ?)}";

    public static final String SELECT_COMMENT_BY_ORDER_ID = "SELECT comment FROM Orders WHERE orderId = ?";

    public static final String UPDATE_ORDER_SET_STATUS_PAID
            = "{call UPDATE_ORDER_SET_STATUS_PAYED()}";

}
