package by.epam.appetizer.dao;

import by.epam.appetizer.dao.exception.DAOException;
import java.util.Date;

public interface TokenDAO {

    void addToken(String hash, Date date, int userId) throws DAOException;

    void getTokenByHash(String hash) throws DAOException;
}
