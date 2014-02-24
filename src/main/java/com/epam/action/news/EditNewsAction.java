package com.epam.action.news;

import com.epam.action.util.NewsConverter;
import com.epam.forms.NewsForm;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditNewsAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws ParseException, IllegalAccessException {

//        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        INewsDAO newsDAO = (INewsDAO) context.getBean("newsDAO");
        int id = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.read(id);

        NewsForm newsForm = (NewsForm) form;
        //request.setAttribute("news",news);
        NewsConverter.NewsToForm(newsForm,news);
        return mapping.findForward("success");
    }
}
