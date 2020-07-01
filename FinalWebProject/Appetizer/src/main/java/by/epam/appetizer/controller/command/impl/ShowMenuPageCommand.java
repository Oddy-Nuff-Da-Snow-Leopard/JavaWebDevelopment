package by.epam.appetizer.controller.command.impl;

import by.epam.appetizer.controller.command.Command;

import by.epam.appetizer.controller.command.exception.CommandException;

import by.epam.appetizer.service.DishService;
import by.epam.appetizer.service.DishCategoryService;
import by.epam.appetizer.service.ServiceFactory;
import by.epam.appetizer.service.exception.ServiceException;

import by.epam.appetizer.entity.Dish;
import by.epam.appetizer.entity.DishCategory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import static by.epam.appetizer.controller.command.configuration.ParameterName.*;
import static by.epam.appetizer.controller.command.configuration.PathToJSP.MENU_PAGE_PATH;

public class ShowMenuPageCommand implements Command {

    private final DishCategoryService dishCategoryService
            = ServiceFactory.getInstance().getDishCategoryService();
    private final DishService dishService = ServiceFactory.getInstance().getDishService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws CommandException {

        List<DishCategory> dishesCategories;
        List<Dish> dishes;
        try {
            dishesCategories = dishCategoryService.getAllDishesCategories();
            dishes = dishService.getAllDishes();
            request.setAttribute(DISHES, dishes);
            request.setAttribute(DISHES_CATEGORIES, dishesCategories);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return MENU_PAGE_PATH;
    }
}
