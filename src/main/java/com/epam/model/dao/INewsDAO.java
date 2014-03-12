package com.epam.model.dao;

import com.epam.exceptions.AppDAOException;
import com.epam.model.entities.News;

import java.util.List;

/**
 * Created by Marat_Chardymau on 2/13/14.
 */
public interface INewsDAO {
    public void save(News news) throws AppDAOException;

    public News read(int id) throws AppDAOException;

    public void update(News news) throws AppDAOException;

    public void delete(int id) throws AppDAOException;

    public void deleteList(int[] ids) throws AppDAOException;

    public List<News> findAll() throws AppDAOException;
}
