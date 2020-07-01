package by.epam.appetizer.service;

import by.epam.appetizer.entity.User;
import by.epam.appetizer.service.exception.ServiceException;

public interface TokenService {

    void addToken(User user) throws ServiceException;

    void getTokenByHash(String hash) throws ServiceException;
}
