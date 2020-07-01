package by.epam.appetizer.service;

import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.exception.ServiceException;

public interface UserService {

    User signUp(String firstName, String lastName, String gender,
            String username, String phoneNumber, String email, String password,
            String confirmedPassword)
            throws ServiceException;

    User signIn(String email, String password) throws ServiceException;
}
