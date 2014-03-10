package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.AbstractDAO;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcNewsDAO extends AbstractDAO implements INewsDAO {

    private static final String ID="id";
    private static final String TITLE="title";
    private static final String CREATED_AT="created_at";
    private static final String BRIEF="brief";
    private static final String CONTENT="content";

    private static final String SAVE_SQL = "INSERT INTO NEWS"
            + "(title,brief,content,created_at) VALUES"
            + "(?,?,?,?)";
    private static final String READ_SQL = "SELECT id,title,brief,content,created_at FROM news WHERE ID=?";
    private static final String UPDATE_SQL = "UPDATE news SET title=?,brief=?,content=?,created_at=? WHERE id=?";
    private static final String DELETE_SQL = "DELETE FROM news WHERE id=?";
    private static final String DELETE_LIST_SQL = "DELETE FROM news WHERE id IN ";
    private static final String FIND_ALL_SQL = "SELECT * FROM NEWS ORDER BY created_at DESC";

    @Override
    public void save(News news) throws AppDAOException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(SAVE_SQL, new String[]{"id"});
            ps.setString(1, news.getTitle());
            ps.setString(2, news.getBrief());
            ps.setString(3, news.getContent());
            ps.setDate(4, news.getCreatedAt());
            //we are trying to get id of inserted record
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idInt = rs.getInt(1);
                news.setId(idInt);
            } else {
                throw new AppDAOException("Creating news failed, no generated key obtained.");
            }
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
                String title = rs.getString(TITLE);
                String brief = rs.getString(BRIEF);
                String content = rs.getString(CONTENT);
                Date createdAt = rs.getDate(CREATED_AT);
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
    public void deleteList(int[] ids) throws AppDAOException {
        Connection connection = null;
        PreparedStatement ps = null;

        //build sql string
        StringBuilder builder = new StringBuilder(DELETE_LIST_SQL);
        builder.append("(");
        int initLength = builder.length();
        for (int i : ids) {
            builder.append("?");
            if (builder.length() != initLength + ids.length * 2 - 1) {
                builder.append(",");
            }
        }
        builder.append(")");

        try {
            connection = super.getConnection();
            ps = connection.prepareStatement(builder.toString());
            for (int i = 1; i <= ids.length; i++) {
                ps.setInt(i, ids[i-1]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new AppDAOException("delete news list failed", e);
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
                int id = rs.getInt(ID);
                String title = rs.getString(TITLE);
                String brief = rs.getString(BRIEF);
                String content = rs.getString(CONTENT);
                Date createdAt = rs.getDate(CREATED_AT);
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
