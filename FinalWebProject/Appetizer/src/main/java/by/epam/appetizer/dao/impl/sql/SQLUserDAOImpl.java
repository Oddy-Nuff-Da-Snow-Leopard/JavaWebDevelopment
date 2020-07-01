package by.epam.appetizer.dao.impl.sql;

import by.epam.appetizer.entity.User;

import by.epam.appetizer.dao.UserDAO;
import by.epam.appetizer.dao.exception.DAOException;
import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.util.Creator;

import java.sql.*;

import static by.epam.appetizer.dao.configuration.SQLQuery.*;

public class SQLUserDAOImpl implements UserDAO {

    private static final ConnectionPool CONNECTION_POOL = ConnectionPool.getInstance();

    @Override
    public boolean checkIfEmailIsAlreadyUsed(String email) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs = connection.prepareCall(SELECT_USER_ID_BY_EMAIL)) {
            cs.setString(1, email);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(2) > 0;
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, email checking failed" + e);
        }
    }

    @Override
    public int signUp(String firstName, String lastName, String gender,
                      String username, String phoneNumber, String email, String password)
            throws DAOException {

        try (Connection connection = CONNECTION_POOL.takeConnection();
             CallableStatement cs1 = connection.prepareCall(INSERT_USER);
             CallableStatement cs2 = connection.prepareCall(INSERT_USER_DATA)) {

            cs1.setString(1, email);
            cs1.setString(2, password);
            cs1.registerOutParameter(3, Types.INTEGER);
            cs1.executeUpdate();

            cs2.setString(1, firstName);
            cs2.setString(2, lastName);
            cs2.setString(3, gender);
            cs2.setString(4, username);
            cs2.setString(5, phoneNumber);
            cs2.executeUpdate();

            return cs1.getInt(3);
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, sign up failed " + e);
        }
    }

    @Override
    public User getUserById(int userId) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_USER_ID)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createUser(rs);
                } else {
                    throw new DAOException("Failed to get user by userId, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, failed to get user by userId " + e);
        }
    }

    @Override
    public User getUserByEmail(String email) throws DAOException {
        try (Connection connection = CONNECTION_POOL.takeConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_EMAIL)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Creator.getInstance().createUser(rs);
                } else {
                    throw new DAOException("Failed to get user by email, result set is empty");
                }
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException in SQLUserDAOImpl, failed to get user by email " + e);
        }
    }

}
