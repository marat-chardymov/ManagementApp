package com.epam.model.dao.impl;

import com.epam.model.dao.AbstractDAO;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;

import java.sql.*;

/**
 * Created by Marat_Chardymau on 2/13/14.
 */
public class NewsDAO extends AbstractDAO implements INewsDAO {
    @Override
    public void save(News news) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = super.getConnection();
            String insertTableSQL = "INSERT INTO NEWS"
                    + "(content, title,brief) VALUES"
                    + "(?,?,?)";
            preparedStatement = connection.prepareStatement(insertTableSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, news.getContent());
            preparedStatement.setString(2, news.getTitle());
            preparedStatement.setString(3, news.getBrief());
            //we are trying to get id of inserted record
//            int affectedRows = preparedStatement.executeUpdate();
//            if (affectedRows == 0) {
//                throw new Exception("Creating answer failed, no rows affected.");
//            }
//            resultSet = preparedStatement.getGeneratedKeys();
//            if (resultSet.next()) {
//                news.setId(resultSet.getInt(1));
//            } else {
//                throw new Exception("Creating answer failed, no generated key obtained.");
//            }
        } catch (SQLException e) {
            throw new Exception("add answer failed", e);
        } finally {
            super.closeEverything(resultSet, preparedStatement, connection);
        }

    }
}
