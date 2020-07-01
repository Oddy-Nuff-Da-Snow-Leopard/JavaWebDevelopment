package by.epam.appetizer.service.impl;

import by.epam.appetizer.dao.DAOFactory;
import by.epam.appetizer.dao.DishDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.Dish;
import by.epam.appetizer.service.DishService;
import by.epam.appetizer.service.exception.ServiceException;
import java.util.List;

public class DishServiceImpl implements DishService {

    private final DishDAO dishDAO = DAOFactory.getInstance().getDishDAO();

    public List<Dish> getAllDishes() throws ServiceException {
        try {
            return dishDAO.getAllDishes();
        } catch (DAOException e) {
            throw new ServiceException("DAOException in DishServiceImpl, failed to get all dishes " + e);
        }
    }
}
