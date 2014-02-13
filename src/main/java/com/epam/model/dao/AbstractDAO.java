package com.epam.model.dao;

import java.sql.*;

public class AbstractDAO {
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "system",
                "sesame");
    }

    protected void closeEverything(ResultSet rs, Statement stmt,
                                   Connection con) throws Exception {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new Exception("error in ResultSet's close()", e);
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                throw new Exception("error in Statement's close()", e);
            }
        }
        if (con != null) {
            con.close();
        }
    }
}
