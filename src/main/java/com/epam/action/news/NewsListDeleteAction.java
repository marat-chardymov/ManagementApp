package com.epam.action.news;

import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewsListDeleteAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

//        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context.xml");
        INewsDAO newsDAO = (INewsDAO) context.getBean("newsDAO");
        DynaActionForm newsDeleteForm = (DynaActionForm) form;
        String[] strDeleteIds = (String[]) newsDeleteForm.get("selectedItems");
        for (String strId : strDeleteIds) {
            int id = Integer.parseInt(strId);
            newsDAO.delete(id);
        }
        return mapping.findForward("success");
    }
}
