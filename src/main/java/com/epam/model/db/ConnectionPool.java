package com.epam.model.db;

import com.epam.exceptions.AppConnectionException;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {

    static {
        Locale.setDefault(Locale.ENGLISH);
    }

    private LinkedBlockingQueue<Connection> vacant = new LinkedBlockingQueue<Connection>();
    private List<Connection> all = new ArrayList<Connection>();
    //pool parameters
    private String driverClassName;
    private String jdbcUrl;
    private String username;
    private String password;
    private String initPoolSize;

    public ConnectionPool() {
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setInitPoolSize(String initPoolSize) {
        this.initPoolSize = initPoolSize;
    }

    private Connection createConnection() throws AppConnectionException {
        try {
            return DriverManager.getConnection(
                    jdbcUrl, username,
                    password);
        } catch (SQLException ex) {
            throw new AppConnectionException("Exception in ConnectionPool.createConnection()", ex);
        }
    }


    public void init()
            throws AppConnectionException {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException ex) {
            throw new AppConnectionException("Exception in ConnectionPool.init():", ex);
        }
        int poolSize = Integer.parseInt(initPoolSize);
        for (int i = 0; i < poolSize; i++) {
            Connection connection = createConnection();
            vacant.add(connection);
            all.add(connection);
        }
    }


    public Connection getConnection() throws AppConnectionException {
        try {
            return vacant.take();
        } catch (InterruptedException ex) {
            throw new AppConnectionException("InterruptedException in ConnectionPool.getConnection(): interrupt while waiting", ex);
        }
    }

    public void release(Connection connection) throws AppConnectionException {
        vacant.add(connection);
    }


    public void destroy() throws AppConnectionException {
        for (Connection connection : all) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new AppConnectionException("connection close() failed", ex);
            }
        }
        all.removeAll(all);
    }

}