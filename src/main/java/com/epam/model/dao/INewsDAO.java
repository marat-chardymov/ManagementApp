package com.epam.model.dao;

import com.epam.model.entities.News;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Marat_Chardymau on 2/13/14.
 */
public interface INewsDAO {
    public void save(News news);

    public News read(int id);

    void delete(News news);

    void update(News news);

    List<News> findAll();
}
