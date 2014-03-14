package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JPANewsDAO implements INewsDAO{

    private static final String FIND_All_SQL="SELECT n FROM News n";
    private static final String FIND_All_SQL="DELETE n FROM News n";

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(News news) throws AppDAOException {
        em.persist(news);
    }

    @Override
    public News read(int id) throws AppDAOException {
        return em.find(News.class,id);
    }

    @Override
    public void update(News news) throws AppDAOException {
        em.merge(news);
    }

    @Override
    public void delete(int id) throws AppDAOException {
      
    }

    @Override
    public void deleteList(int[] ids) throws AppDAOException {

    }

    @Override
    public List<News> findAll() throws AppDAOException {
        return em.createQuery(FIND_All_SQL).getResultList();
    }
}
