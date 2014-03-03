package com.epam.model.dao;

import com.epam.exceptions.AppConnectionException;
import com.epam.exceptions.AppDAOException;
import com.epam.model.db.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class AbstractDAO {
    private ConnectionPool pool;

    public void setPool(ConnectionPool pool) {
        this.pool = pool;
    }

    protected void closeEverything(ResultSet rs, Statement stmt,
                                   Connection con) throws AppDAOException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new AppDAOException("error in ResultSet's close()", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new AppDAOException("error in Statement's close()", e);
            }
        }
        if (con != null) {
            try {
                pool.release(con);
            } catch (AppConnectionException e) {
                throw new AppDAOException("can't release connection", e);
            }
        }
    }

    protected void closeSC(Statement stmt,
                           Connection con) throws AppDAOException {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new AppDAOException("can't close statement", e);
            }
        }
        if (con != null) {
            try {
                pool.release(con);
            } catch (AppConnectionException e) {
                throw new AppDAOException("can't release connection", e);
            }
        }
    }

    protected Connection getConnection() throws AppDAOException {
        try {
            return pool.getConnection();
        } catch (AppConnectionException e) {
            throw new AppDAOException("can't get connection", e);
        }
    }
}
