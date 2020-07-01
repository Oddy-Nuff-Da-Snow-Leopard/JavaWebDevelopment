package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.DishCategoryDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.DishCategory;
import by.epam.appetizer.service.DishCategoryService;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public class DishCategoryServiceImpl implements DishCategoryService {

    private final DishCategoryDAO dishCategoryDAO = DAOFactory.getInstance().getDishCategoryDAO();

    public List<DishCategory> getAllDishesCategories() throws ServiceException {
        try {
            return dishCategoryDAO.getAllDishesCategories();
        } catch (DAOException e) {
            throw new ServiceException("DAOException in DishCategoryServiceImpl, failed to get all dishes " + e);
        }
    }
}
