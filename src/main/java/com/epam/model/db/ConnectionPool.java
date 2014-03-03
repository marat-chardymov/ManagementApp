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

    private LinkedBlockingDeque<Connection> connections = new LinkedBlockingDeque<Connection>();
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
        int poolSize= Integer.parseInt(initPoolSize);
        for (int i = 0; i < poolSize ; i++) {
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
            return getConnection();
        }
    }


    public void release(Connection connection) throws AppConnectionException{
        try {
            if (!connection.isClosed()) {
                connections.add(connection);
            }
        } catch (SQLException ex) {
            throw new AppConnectionException("can't release connection; isClosed() check failed",ex);
        }
    }


    public void destroy() throws AppConnectionException {
        for (Iterator<Connection> it = connections.iterator(); it.hasNext();) {
            Connection c = it.next();
            try {
                c.close();
            } catch (SQLException ex) {
                throw new AppConnectionException("connection close() failed",ex);
            }
        }
        connections.removeAll(connections);
    }

}