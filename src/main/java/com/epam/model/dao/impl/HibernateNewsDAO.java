package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class HibernateNewsDAO implements INewsDAO {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(News news) throws AppDAOException {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    @Override
    public News read(int id) throws AppDAOException {
        Session session = sessionFactory.getCurrentSession();
        return (News) session.get(News.class, new Integer(id));
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
