package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.dao.UserCartDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;

import java.sql.*;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;

public class SQLUserCartDAOImpl implements UserCartDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public int addUserCart(int userId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(INSERT_USER_CART)) {
            cs.setInt(1, userId);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.executeUpdate();
            int inserted_row_id = cs.getInt(2);
            return inserted_row_id;
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserCartDAOImpl, failed to add user cart " + e);
        }
    }
}
