package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import com.google.common.primitives.Ints;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPANewsDAO implements INewsDAO {

    private static final String FIND_All = "SELECT n FROM News n";
    private static final String DELETE = "DELETE FROM News news WHERE news.id= :id";
    private static final String DELETE_LIST = "DELETE News news WHERE news.id IN (:idList)";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(News news) throws AppDAOException {
        em.persist(news);
    }

    @Override
    public News read(int id) throws AppDAOException {
        return em.find(News.class, id);
    }

    @Override
    public void update(News news) throws AppDAOException {
        em.merge(news);
    }

    @Override
    public void delete(int id) throws AppDAOException {
        Query query = em.createQuery(DELETE);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteList(int[] ids) throws AppDAOException {
        Query query = em.createQuery(DELETE_LIST);
        List<Integer> idList = Ints.asList(ids);
        query.setParameter("idList", idList);
        query.executeUpdate();
    }

    @Override
    public List<News> findAll() throws AppDAOException {
        return em.createQuery(FIND_All).getResultList();
    }
}
