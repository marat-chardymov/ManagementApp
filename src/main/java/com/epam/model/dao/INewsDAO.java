package com.epam.model.dao;

import com.epam.exceptions.AppDAOException;
import com.epam.model.entities.News;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Marat_Chardymau on 2/13/14.
 */
public interface INewsDAO {
    public void save(News news) throws AppDAOException;

    public News read(int id) throws AppDAOException;

    void update(News news) throws AppDAOException;

    void delete(int id) throws AppDAOException;

    List<News> findAll() throws AppDAOException;
}
