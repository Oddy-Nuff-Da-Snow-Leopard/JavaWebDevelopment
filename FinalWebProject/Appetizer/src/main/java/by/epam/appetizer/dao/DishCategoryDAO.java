package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.entity.DishCategory;
import java.util.List;

public interface DishCategoryDAO {

    List<DishCategory> getAllDishesCategories() throws DAOException;
}
