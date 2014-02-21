package com.epam.action.news;

import com.epam.action.util.NewsConverter;
import com.epam.forms.NewsForm;
import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

/**
 * Created by Marat_Chardymau on 2/19/14.
 */
public class NewsDeleteAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws ParseException, IllegalAccessException {

        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        int id = Integer.parseInt(request.getParameter("id"));
        newsDAO.delete(id);
        return mapping.findForward("success");
    }
}
