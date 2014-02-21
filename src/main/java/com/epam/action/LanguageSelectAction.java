package com.epam.action;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by Marat_Chardymau on 2/21/14.
 */
public class LanguageSelectAction extends DispatchAction {

    public ActionForward english(ActionMapping mapping,ActionForm form,
                                 HttpServletRequest request,HttpServletResponse response)
            throws Exception {

        request.getSession().setAttribute(
                Globals.LOCALE_KEY, Locale.ENGLISH);

        return mapping.findForward("success");
    }

    public ActionForward russian(ActionMapping mapping,ActionForm form,
                                HttpServletRequest request,HttpServletResponse response)
            throws Exception {

        request.getSession().setAttribute(
                Globals.LOCALE_KEY, new Locale("ru"));

        return mapping.findForward("success");
    }
}