package com.epam.action.news;

import com.epam.forms.NewsForm;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws ParseException, IllegalAccessException {

        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        NewsForm newsForm = (NewsForm) form;

        String title = newsForm.getTitle();
        String brief = newsForm.getBrief();
        String content = newsForm.getContent();
        String strDate = newsForm.getDate();
        //convert string with date to Date object
        DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dFormat.parse(strDate);

        News news = new News(title, brief, content, date);

        //if id exists we update current news, else - add new
        if (!request.getParameter("id").isEmpty()) {
            int id = Integer.parseInt(request.getParameter("id"));
            news.setId(id);
            newsDAO.update(news);
            return mapping.findForward("successEdit");
        } else {
            newsDAO.save(news);
            form.reset(mapping, request);
            return mapping.findForward("successAdd");
        }

    }
}
