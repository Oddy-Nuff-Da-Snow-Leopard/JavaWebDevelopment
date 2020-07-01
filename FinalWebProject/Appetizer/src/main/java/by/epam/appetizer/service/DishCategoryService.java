package by.epam.appetizer.service;

import by.epam.appetizer.entity.DishCategory;
import by.epam.appetizer.service.exception.ServiceException;

import java.util.List;

public interface DishCategoryService {

    List<DishCategory> getAllDishesCategories() throws ServiceException;
    
    // void addDishCategory(params, not entity)
}
