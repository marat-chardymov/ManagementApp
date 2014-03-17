package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import com.google.common.primitives.Ints;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Repository
@Transactional
public class HibernateNewsDAO implements INewsDAO {

    private static final String HQL_DELETE = "delete from News where id= :id";
    private static final String HQL_DELETE_LIST = "delete News where id in (:idList)";

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.save(news);
    }

    @Override
    public News read(int id) {
        Session session = sessionFactory.getCurrentSession();
        return (News) session.get(News.class, new Integer(id));
    }

    @Override
    public void update(News news) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(news);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL_DELETE);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteList(int[] ids) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(HQL_DELETE_LIST);
        List<Integer> idList = Ints.asList(ids);
        query.setParameterList("idList", idList);
        query.executeUpdate();
    }

    @Override
    public List<News> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(News.class);
        criteria.addOrder(Order.desc("createdAt"));
        return criteria.list();
    }
}
