package com.epam.action;

import com.epam.model.dao.INewsDAO;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNewsAction extends ActionSupport {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {

        INewsDAO newsDAO = (INewsDAO) getWebApplicationContext().getBean("newsDAO");
        DynaActionForm newsForm = (DynaActionForm) form;
        System.out.println("asdf");
        return mapping.findForward("success");
    }
}
