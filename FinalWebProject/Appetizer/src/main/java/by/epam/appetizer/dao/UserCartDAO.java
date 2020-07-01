package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;

public interface UserCartDAO {

    public int addUserCart(int userId) throws DAOException;

}
