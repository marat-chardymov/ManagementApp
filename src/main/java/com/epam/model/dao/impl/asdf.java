package com.epam.model.dao.impl;

import com.epam.exceptions.AppDAOException;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import com.google.common.primitives.Ints;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Marat_Chardymau on 3/12/14.
 */
public class asdf {
    public static void main(String[] args) throws AppDAOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"application-context.xml"});
        INewsDAO newsDAO = (INewsDAO) ctx.getBean("JPANewsDAO");

//        check save
        java.util.Date today = new java.util.Date();
        News news = new News("888", "777", "666",new Date(today.getTime()));
        newsDAO.save(news);

//        check read
//        java.util.Date today = new java.util.Date();
//        News news = new News("111", "222", "333",new Date(today.getTime()));
//        newsDAO.save(news);
//        News readedNews=newsDAO.read(news.getId());
//        System.out.println("tadam");

//        check update
//        java.util.Date today = new java.util.Date();
//        News news = new News("222", "333", "444",new Date(today.getTime()));
//        newsDAO.save(news);
//        news.setTitle("2222");
//        news.setBrief("3333");
//        news.setContent("4444");
//        newsDAO.update(news);
//        System.out.println("tadam");

        //check delete
//        java.util.Date today = new java.util.Date();
//        News news = new News("deleteTest", "deleteTest", "deleteTest",new Date(today.getTime()));
//        newsDAO.save(news);
//        newsDAO.delete(news.getId());

        //check findAll
//        List<News> newsList = newsDAO.findAll();
//        System.out.println("tadam");

        //check delete list
//        int ids[] = {681, 682};
//        newsDAO.deleteList(ids);
    }

}
