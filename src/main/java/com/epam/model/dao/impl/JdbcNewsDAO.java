package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.AbstractDAO;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDAO extends AbstractDAO implements INewsDAO {

    private static final String SAVE_SQL = "INSERT INTO NEWS"
            + "(title,brief,content,created_at) VALUES"
            + "(?,?,?,?)";
    private static final String READ_SQL = "SELECT id,title,brief,content,created_at FROM news WHERE ID=?";
    private static final String UPDATE_SQL = "UPDATE news SET title=?,brief=?,content=?,created_at=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM news WHERE id=?";
    private static final String FIND_ALL_SQL = "SELECT * FROM NEWS ORDER BY created_at DESC";

    @Override
    public void save(News news) throws AppDAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(SAVE_SQL);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getBrief());
            ps.setString(3, news.getContent());
            ps.setDate(4, new java.sql.Date(news.getCreatedAt().getTime()));
            //we are trying to get id of inserted record
            ps.executeUpdate();
//            rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                news.setId(rs.getInt(1));
//            } else {
//                throw new AppDAOException("Creating news failed, no generated key obtained.");
//            }
        } catch (SQLException e) {
            throw new AppDAOException("save news failed", e);
        } finally {
            super.closeEverything(rs, ps, connection);
        }
    }

    @Override
    public News read(int id) throws AppDAOException {
        News news = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(READ_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String brief = rs.getString("brief");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                news = new News(title, brief, content, createdAt);
                news.setId(id);
            }
        } catch (SQLException e) {
            throw new AppDAOException("find news failed", e);
        } finally {
            super.closeEverything(rs, ps, connection);
        }
        return news;
    }

    @Override
    public void update(News news) throws AppDAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(UPDATE_SQL);
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getBrief());
            ps.setString(3, news.getContent());
            ps.setDate(4, news.getCreatedAt());
            ps.setInt(5, news.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppDAOException("update news failed", e);
        } finally {
            super.closeSC(ps, connection);
        }
    }

    @Override
    public void delete(int id) throws AppDAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(DELETE_SQL);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppDAOException("delete news failed", e);
        } finally {
            super.closeSC(ps, connection);
        }
    }

    @Override
    public List<News> findAll() throws AppDAOException {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        List<News> newsList = new ArrayList<News>();
        try {
            connection = super.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(FIND_ALL_SQL);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("title");
                String brief = rs.getString("brief");
                String content = rs.getString("content");
                Date createdAt = rs.getDate("created_at");
                News news = new News(title, brief, content, createdAt);
                news.setId(id);
                newsList.add(news);
            }
        } catch (SQLException e) {
            throw new AppDAOException("findAll() subjects method failed", e);
        } finally {
            super.closeEverything(rs, st, connection);
        }
        return newsList;
    }
}
