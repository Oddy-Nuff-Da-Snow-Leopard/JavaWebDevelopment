package by.epam.appetizer.dao.pool;

import by.epam.appetizer.dao.pool.exception.ConnectionPoolException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public final class ConnectionPool {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPool.class);

    private static final int DEFAULT_POOL_SIZE = 10;

    private BlockingQueue<ProxyConnection> connectionQueue;

    private String driver;
    private String url;
    private String user;
    private String password;
    private int poolSize;

    private static class ConnectionPoolHolder {

        private static final ConnectionPool INSTANCE = new ConnectionPool();
    }

    private ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driver = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.password = dbResourceManager.getValue(DBParameter.DB_PASSWORD);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        try {
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = DEFAULT_POOL_SIZE;
            LOGGER.info(e.getMessage());
        }
    }

    public static ConnectionPool getInstance() {
        return ConnectionPoolHolder.INSTANCE;
    }

    public void initConnectionPool() throws ConnectionPoolException {
        try {
            Class.forName(driver);
            connectionQueue = new ArrayBlockingQueue<>(poolSize);
            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, password);
                connectionQueue.add(new ProxyConnection(connection));
            }
        } catch (ClassNotFoundException e) { // change message
            throw new ConnectionPoolException("Database driver class not found", e);
        } catch (SQLException e) { // change message
            throw new ConnectionPoolException("SQLException in connection pool", e);
        }
    }

    public void destroyConnectionPool() {
        try {
            for (int i = 0; i < connectionQueue.size(); i++) {
                takeConnection().closeConnection();
            }
        } catch (SQLException e) { // change message
            LOGGER.fatal("Can not close connection. Reason :" + e.getMessage());
        }
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                DriverManager.deregisterDriver(drivers.nextElement());
            }
        } catch (SQLException e) { // change message
            LOGGER.fatal("Can not deregister driver. Reason :" + e.getMessage());
        }
    }

    public synchronized ProxyConnection takeConnection() {
        ProxyConnection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) { // change message
            LOGGER.fatal("Can't take connection from pool", e);

        }
        return connection;
    }

    void putBackConnection(ProxyConnection connection) {
        connectionQueue.offer(connection);
    }
}
