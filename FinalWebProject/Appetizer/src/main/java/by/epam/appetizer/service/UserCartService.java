package by.epam.appetizer.service;

import by.epam.appetizer.service.exception.ServiceException;

public interface UserCartService {

    int addUserCart(int userId) throws ServiceException;
}
