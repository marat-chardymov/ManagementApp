package com.epam.model.dao;


import com.epam.model.dao.impl.JdbcNewsDAO;
import com.epam.model.entities.News;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class NewsDAOTest {
    @Test
    public void createTest() throws Exception {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("application-context.xml");
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        News news = new News("a", "b", "c");
        newsDAO.save(news);
        assertNotNull(news.getId());
    }

}
