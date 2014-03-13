package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;

/**
 * Created by Marat_Chardymau on 3/12/14.
 */
public class asdf {
    public static void main(String[] args) throws AppDAOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
        java.util.Date today = new java.util.Date();
        News news = new News("888", "777", "666",new Date(today.getTime()));
        INewsDAO newsDAO = (INewsDAO) ctx.getBean("hibernateNewsDAO");
        newsDAO.save(news);
    }
}
