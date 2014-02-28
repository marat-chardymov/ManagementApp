package com.epam.model.db;

import com.epam.exceptions.AppConnectionException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ConnectionPool {

    private static final Logger LOG = Logger.getLogger(ConnectionPool.class.getName());
    private static final ConnectionPool instance = new ConnectionPool();
    private LinkedBlockingDeque<Connection> connections = new LinkedBlockingDeque<Connection>();
    private Properties properties;


    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    private Connection createConnection() throws AppConnectionException {
        try {
            return DriverManager.getConnection(
                    properties.getProperty("jdbcUrl"), properties.getProperty("user"),
                    properties.getProperty("password"));
        } catch (SQLException ex) {
            LOG.log(Level.ERROR, "Exception in DatabasePool.createConnection",
                    ex);
            throw new AppConnectionException("ERROR_CONNECTION_TO_DB", ex);
        }
    }


    public void init(Properties properties)
            throws AppConnectionException {
        this.properties = properties;
        try {
            Class.forName(properties.getProperty("jdbcUrl"));
        } catch (ClassNotFoundException ex) {
            LOG.log(Level.ERROR, "Exception in DatabasePool.init:", ex);
            throw new AppConnectionException("ERROR_LOAD_DB_DRIVER", ex);
        }
        int initPoolSize= Integer.parseInt(properties.getProperty("initialPoolSize"));
        for (int i = 0; i < initPoolSize ; i++) {
            connections.add(createConnection());
        }
    }


    public Connection getConnection() throws AppConnectionException {
        try {
            Connection connection = connections.poll(500, TimeUnit.MILLISECONDS);
            if (connection == null) {
                connections.add(createConnection());
                connection = connections.poll();
            }
            return connection;
        } catch (InterruptedException ex) {
            LOG.log(Level.ERROR, "Exception in DatabasePool.getConnection:", ex);
            return getConnection();
        } catch (AppConnectionException ex1) {
            LOG.log(Level.ERROR, "Exception in DatabasePool.getConnection:",
                    ex1);
            throw new AppConnectionException("ERROR_CONNECTION_TO_DB", ex1);
        }
    }


    public void release(Connection connection) {
        try {
            if (!connection.isClosed()) {
                connections.add(connection);
            }
        } catch (SQLException ex) {
            LOG.log(Level.ERROR, "Exception in Databasepool.release", ex);
        }
    }


    public void destroy() {
        for (Iterator<Connection> it = connections.iterator(); it.hasNext();) {
            Connection c = it.next();
            try {
                c.close();
            } catch (SQLException ex) {
                LOG.log(Level.ERROR, "Exception in DatabasePool.destroy:", ex);
            }
        }
        connections.removeAll(connections);
    }

}