package by.epam.appetizer.service;

import by.epam.appetizer.service.impl.*;

public final class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final TokenService tokenService = new TokenServiceImpl();
    private final DishService dishService = new DishServiceImpl();
    private final DishCategoryService dishCategoryService = new DishCategoryServiceImpl();
    private final UserCartService userCartService = new UserCartServiceImpl();
    private final CartItemService cartItemService = new CartItemServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return userService;
    }
    public TokenService getTokenService() {
        return tokenService;
    }
    

    public DishService getDishService() {
        return dishService;
    }

    public DishCategoryService getDishCategoryService() {
        return dishCategoryService;
    }

    public UserCartService getUserCartService() {
        return userCartService;
    }

    public CartItemService getCartItemService() {
        return cartItemService;
    }

    public OrderService getOrderService() {
        return orderService;
    }
}
