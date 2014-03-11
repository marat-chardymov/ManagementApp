package com.epam.action.news;

import com.epam.exceptions.AppActionException;
import com.epam.exceptions.AppDAOException;
import com.epam.forms.NewsForm;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public final class NewsAction extends DispatchAction {

    private INewsDAO newsDAO;
    private static final String SUCCESS_LIST = "successList";
    private static final String REDIRECT_LIST = "redirectList";
    private static final String SUCCESS_ADD = "successAdd";
    private static final String SUCCESS_EDIT = "successEdit";
    private static final String REDIRECT_VIEW = "redirectView";
    private static final String SUCCESS_VIEW = "successView";

    public void setNewsDAO(INewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    public INewsDAO getNewsDAO() {
        return newsDAO;
    }

    public ActionForward list(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws AppActionException {
        INewsDAO newsDAO = getNewsDAO();
        List<News> newsList = null;
        try {
            newsList = newsDAO.findAll();
        } catch (AppDAOException e) {
            throw new AppActionException("NewsAction exception on list()", e);
        }
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNewsList(newsList);
        return mapping.findForward(SUCCESS_LIST);
    }

    public ActionForward deleteList(ActionMapping mapping, ActionForm form,
                                    HttpServletRequest request, HttpServletResponse response) throws AppActionException {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsForm = (NewsForm) form;
        int[] deleteIds = newsForm.getSelectedItems();
        List<News> newsList = null;
        try {
            newsDAO.deleteList(deleteIds);
        } catch (AppDAOException e) {
            throw new AppActionException("NewsAction exception on deleteList()", e);
        }
        return mapping.findForward(REDIRECT_LIST);
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request, HttpServletResponse response) throws AppActionException {
        NewsForm newsForm = (NewsForm) form;
        INewsDAO newsDAO = getNewsDAO();
        int id = newsForm.getNews().getId();
        List<News> newsList = null;
        try {
            newsDAO.delete(id);
        } catch (AppDAOException e) {
            throw new AppActionException("NewsAction exception on delete()", e);
        }
        return mapping.findForward(REDIRECT_LIST);
    }

    public ActionForward add(ActionMapping mapping, ActionForm form,
                             HttpServletRequest request, HttpServletResponse response) {
        News news = new News();
        long time = new Date().getTime();
        java.sql.Date sqlDate = new java.sql.Date(time);
        news.setCreatedAt(sqlDate);
        NewsForm newsForm = (NewsForm) form;
        newsForm.setNews(news);
        return mapping.findForward(SUCCESS_ADD);
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws AppActionException {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsForm = (NewsForm) form;
        int id = newsForm.getNews().getId();
        News news = null;
        try {
            news = newsDAO.read(id);
        } catch (AppDAOException e) {
            throw new AppActionException("NewsAction exception on read()", e);
        }
        newsForm.setNews(news);
        return mapping.findForward(SUCCESS_EDIT);
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws AppActionException {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsForm = (NewsForm) form;
        News news = newsForm.getNews();
        //if id exists we update current news, else - add new
        int newsId = news.getId();
        if (newsId != 0) {
            try {
                newsDAO.update(news);
            } catch (AppDAOException e) {
                throw new AppActionException("NewsAction exception on save()", e);
            }
            return mapping.findForward(REDIRECT_VIEW);
        } else {
            try {
                newsDAO.save(news);
            } catch (AppDAOException e) {
                throw new AppActionException("NewsAction exception on save()", e);
            }
            newsForm.getNews().setId(news.getId());
            return mapping.findForward(REDIRECT_VIEW);
        }
    }

    public ActionForward view(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request, HttpServletResponse response) throws ParseException, AppActionException {
        INewsDAO newsDAO = getNewsDAO();
        NewsForm newsForm = (NewsForm) form;
        int id = newsForm.getNews().getId();
        News news = null;
        try {
            news = newsDAO.read(id);
        } catch (AppDAOException e) {
            throw new AppActionException("NewsAction exception on view()", e);
        }
        newsForm.setNews(news);
        return mapping.findForward(SUCCESS_VIEW);
    }

}
