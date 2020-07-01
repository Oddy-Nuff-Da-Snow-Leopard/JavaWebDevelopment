package by.epam.appetizer.dao;

import by.epam.appetizer.entity.User;
import by.epam.appetizer.dao.exception.DAOException;

public interface UserDAO {

    boolean checkIfEmailIsAlreadyUsed(String email) throws DAOException;

    int signUp(String firstName, String lastName, String gender,
            String username, String phoneNumber, String email, String password)
            throws DAOException;

    User getUserById(int userId) throws DAOException;

    User getUserByEmail(String email) throws DAOException;
}
