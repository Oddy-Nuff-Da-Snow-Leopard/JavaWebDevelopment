package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.Dish;
import java.util.List;

public interface DishDAO {

    List<Dish> getAllDishes() throws DAOException;
    
    Dish getDishById(int dishId) throws DAOException;
}
