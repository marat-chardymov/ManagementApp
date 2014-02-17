package com.epam.action;

import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public class NewsListAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("application-context.xml");
        INewsDAO newsDAO = (INewsDAO) beanFactory.getBean("newsDao");
        List<News> newsList=newsDAO.findAll();
        request.setAttribute("newsList", newsList);
        return mapping.findForward("success");
    }
}
