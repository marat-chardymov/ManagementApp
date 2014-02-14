package com.epam.model.dao;


import com.epam.model.dao.impl.NewsDAO;
import com.epam.model.entities.News;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class NewsDAOTest {
    @Test
    public void createTest() throws Exception {
        INewsDAO newsDAO = new NewsDAO();
        News news = new News("fdsa", "fdas", "fdsa");
        newsDAO.save(news);
        System.out.println(news.getId());
        assertNotNull(news.getId());
    }

}
