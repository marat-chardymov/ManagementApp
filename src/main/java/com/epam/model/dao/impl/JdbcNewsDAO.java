package com.epam.model.dao.impl;

import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcNewsDAO  extends JdbcDaoSupport implements INewsDAO {

    @Override
    public void save(News news) throws Exception {
        String sql = "INSERT INTO NEWS"
                + "(title,brief,content) VALUES"
                + "(?,?,?)";

        getJdbcTemplate().update(sql, new Object[]{news.getTitle(),
                news.getBrief(), news.getContent()
        });
    }
}
