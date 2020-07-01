package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.dao.TokenDAO;

import static by.epam.appetizer.dao.configuration.SQLQuery.INSERT_TOKEN;

import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.Callable;

public class SQLTokenDAOImpl implements TokenDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public void addToken(String hash, Date date, int userId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_TOKEN)) {
            ps.setString(1, hash);
            ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
            ps.setInt(3, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in TokenDAO, failed to add token " + e);
        }
    }

    @Override
    public void getTokenByHash(String hash) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall("SELECT_TOKEN_BY_HASH")) {
//            ps.setString(1, hash);
//            ps.setTimestamp(2, new java.sql.Timestamp(date.getTime()));
//            ps.setInt(3, userId);
//            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("SQLException in TokenDAO, failed to add token " + e);
        }
    }

}
