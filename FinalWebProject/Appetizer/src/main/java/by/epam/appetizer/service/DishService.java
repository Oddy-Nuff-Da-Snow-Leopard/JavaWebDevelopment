package by.epam.appetizer.service;

import by.epam.appetizer.entity.Dish;
import by.epam.appetizer.service.exception.ServiceException;

import java.util.List;

public interface DishService {

    List<Dish> getAllDishes() throws ServiceException;
    
    // void addDish(params, not entity)
}
