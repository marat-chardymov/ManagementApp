package com.epam.action.news;

import com.epam.model.dao.INewsDAO;
import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class NewsListDeleteAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        DynaActionForm newsDeleteForm = (DynaActionForm) form;
        String[] strDeleteIds = (String[]) newsDeleteForm.get("selectedItems");
        for (String strId : strDeleteIds) {
            int id = Integer.parseInt(strId);
            newsDAO.delete(id);
        }
        return mapping.findForward("success");
    }
}
