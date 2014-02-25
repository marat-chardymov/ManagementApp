package com.epam.action.news;

import com.epam.action.util.NewsConverter;
import com.epam.forms.NewsForm;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAction extends DispatchAction {

    public ActionForward list(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) {
        INewsDAO newsDAO = getNewsDAO();
        List<News> newsList = newsDAO.findAll();
        request.setAttribute("newsList", newsList);
        return mapping.findForward("successList");
    }

    public ActionForward deleteList(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsDeleteForm = (NewsForm) form;
        String[] strDeleteIds = (String[]) newsDeleteForm.getSelectedItems();
        for (String strId : strDeleteIds) {
            int id = Integer.parseInt(strId);
            newsDAO.delete(id);
        }
        return mapping.findForward("successDeleteList");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) {
        INewsDAO newsDAO = getNewsDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        newsDAO.delete(id);
        return mapping.findForward("successDelete");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) throws ParseException {
        return mapping.findForward("successAdd");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws ParseException {
        INewsDAO newsDAO = getNewsDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.read(id);
        NewsForm newsForm = (NewsForm) form;
        NewsConverter.newsToForm(newsForm, news);
        return mapping.findForward("successEdit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws ParseException {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsForm = (NewsForm) form;
        News news = NewsConverter.formToNews(newsForm);
        //if id exists we update current news, else - add new
        if (!request.getParameter("id").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("id"));
            news.setId(id);
            newsDAO.update(news);
            return mapping.findForward("successSave");
        } else {
            newsDAO.save(news);
            form.reset(mapping, request);
            return mapping.findForward("successSave");
        }
    }

    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws ParseException {
        INewsDAO newsDAO = getNewsDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.read(id);
        NewsForm newsForm = (NewsForm) form;
        NewsConverter.newsToForm(newsForm, news);
        return mapping.findForward("successView");
    }

    private INewsDAO getNewsDAO() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        return (INewsDAO) context.getBean("newsDAO");
    }

}
