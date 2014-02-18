package com.epam.model.dao;


import com.epam.model.entities.News;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NewsDAOTest {
    private static BeanFactory beanFactory = null;

    @BeforeClass
    public static void setUp() {
        beanFactory = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
    }

    @Test
    public void createTest() {
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        News news = new News("createTest", "createTest", "createTest");
        newsDAO.save(news);
    }

    @Test
    public void readTest() {
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        News news = new News("readTest", "readTest", "readTest");
        newsDAO.save(news);
        News readedNews = newsDAO.read(news.getId());
        assertNotNull(readedNews);
    }

    @Test
    public void updateTest() {
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        News news = new News("updateTest", "updateTest", "updateTest");
        newsDAO.save(news);
        news = newsDAO.read(news.getId());
        news.setTitle("updateTest_mod_title");
        news.setBrief("updateTest_mod_brief");
        news.setContent("updateTest_mod_content");
        newsDAO.update(news);
        News afterUpdate = newsDAO.read(news.getId());
        Assert.assertNotNull(afterUpdate);
    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void deleteTest() {
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        News news = new News("deleteTest", "deleteTest", "deleteTest");
        newsDAO.save(news);
        newsDAO.delete(news.getId());
        newsDAO.read(news.getId());

    }

    @Test
    public void findAll() {
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        List<News> list = newsDAO.findAll();
        Assert.assertNotNull(list);
    }


}
