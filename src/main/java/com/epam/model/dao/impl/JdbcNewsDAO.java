package com.epam.model.dao.impl;

import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JdbcNewsDAO extends JdbcDaoSupport implements INewsDAO {

    @Override
    public void save(final News news) {
        final String sql = "INSERT INTO NEWS"
                + "(title,brief,content) VALUES"
                + "(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(sql, new String[]{"id"});
                        ps.setString(1, news.getTitle());
                        ps.setString(2, news.getBrief());
                        ps.setString(3, news.getContent());
                        return ps;
                    }
                },
                keyHolder);
        news.setId(keyHolder.getKey().intValue());
    }

    @Override
    public News read(int id) {
        String sql = "SELECT id,title,brief,content FROM news WHERE ID=?";
        return (News) getJdbcTemplate().queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper(News.class));
    }

    @Override
    public void update(News news) {
        String sql = "UPDATE news SET title=?,brief=?,content=? WHERE id=?";
        getJdbcTemplate().update(sql, news.getTitle(), news.getBrief(), news.getContent(), news.getId());
    }

    @Override
    public List<News> findAll() {
        String sql = "SELECT * FROM NEWS";

        List<News> newsList = new ArrayList<News>();

        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            News news = new News();
            news.setId((int)(row.get("ID")));
            news.setTitle((String)row.get("title"));
            news.setBrief((String)row.get("brief"));
            news.setContent((String)row.get("content"));
            newsList.add(news);
        }

        return newsList;
    }

    @Override
    public void delete(News news) {
        int id = news.getId();
        String sql = "DELETE FROM news WHERE id=?";
        getJdbcTemplate().update(sql, id);
    }


}
