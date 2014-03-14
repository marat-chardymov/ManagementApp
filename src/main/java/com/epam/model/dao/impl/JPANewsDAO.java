package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;


public class JPANewsDAO implements INewsDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(News news) throws AppDAOException {

    }

    @Override
    public News read(int id) throws AppDAOException {
        return null;
    }

    @Override
    public void update(News news) throws AppDAOException {

    }

    @Override
    public void delete(int id) throws AppDAOException {

    }

    @Override
    public void deleteList(int[] ids) throws AppDAOException {

    }

    @Override
    public List<News> findAll() throws AppDAOException {
        return null;
    }
}
