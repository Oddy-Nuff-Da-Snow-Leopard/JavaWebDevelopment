package by.epam.appetizer.controller.listener;

import by.epam.appetizer.dao.pool.ConnectionPool;
import by.epam.appetizer.dao.pool.exception.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConnectionPoolListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ConnectionPoolListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initConnectionPool();
            LOGGER.info("Connection pool initialized successfully");
        } catch (ConnectionPoolException e) {
            LOGGER.error("ConnectionPoolException during initializing", e);
            throw new ExceptionInInitializerError("Could not initialize pool!");
        }
    }


    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().destroyConnectionPool();
        LOGGER.info("Connection pool destroyed successfully");
    }
}

