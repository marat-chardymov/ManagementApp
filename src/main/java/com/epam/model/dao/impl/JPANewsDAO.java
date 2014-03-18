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
        Query query = em.createNamedQuery("DELETE");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void deleteList(int[] ids) {
        Query query = em.createNamedQuery("DELETE_LIST");
        List<Integer> idList = Ints.asList(ids);
        query.setParameter("idList", idList);
        query.executeUpdate();
    }

    @Override
    public List<News> findAll() {
        Query query = em.createNamedQuery("FIND_ALL");
        return query.getResultList();
    }
}
