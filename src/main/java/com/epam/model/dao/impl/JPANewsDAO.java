package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import com.google.common.primitives.Ints;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPANewsDAO implements INewsDAO {

    private static final String FIND_All = "SELECT n FROM News n ORDER BY n.createdAt DESC";
    private static final String DELETE = "DELETE FROM News news WHERE news.id= :id";
    private static final String DELETE_LIST = "DELETE News news WHERE news.id IN (:idList)";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(News news) {
        em.persist(news);
    }

    @Override
    public News read(int id) {
        return em.find(News.class, id);
    }

    @Override
    public void update(News news) {
        em.merge(news);
    }

    @Override
    public void delete(int id) {
        Query query = em.createQuery(DELETE);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteList(int[] ids) {
        Query query = em.createQuery(DELETE_LIST);
        List<Integer> idList = Ints.asList(ids);
        query.setParameter("idList", idList);
        query.executeUpdate();
    }

    @Override
    public List<News> findAll() {
        return em.createQuery(FIND_All).getResultList();
    }
}
