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

//        check save
//        java.util.Date today = new java.util.Date();
//        News news = new News("888", "777", "666",new Date(today.getTime()));
//        INewsDAO newsDAO = (INewsDAO) ctx.getBean("hibernateNewsDAO");
//        newsDAO.save(news);

//        check read
//        java.util.Date today = new java.util.Date();
//        News news = new News("111", "222", "333",new Date(today.getTime()));
//        INewsDAO newsDAO = (INewsDAO) ctx.getBean("hibernateNewsDAO");
//        newsDAO.save(news);
//        News readedNews=newsDAO.read(news.getId());
//        System.out.println("tadam");

//        check update
//        java.util.Date today = new java.util.Date();
//        News news = new News("222", "333", "444",new Date(today.getTime()));
//        INewsDAO newsDAO = (INewsDAO) ctx.getBean("hibernateNewsDAO");
//        newsDAO.save(news);
//        news.setTitle("2222");
//        news.setBrief("3333");
//        news.setContent("4444");
//        newsDAO.update(news);
//        System.out.println("tadam");
    }

}
