package com.epam.action;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class LanguageSelectAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) {
        String loc = request.getParameter("loc");
        if(loc!=null){
            request.getSession().setAttribute(
                    Globals.LOCALE_KEY, new Locale(loc));
        }else{
            request.getSession().setAttribute(
                    Globals.LOCALE_KEY, Locale.ENGLISH);
        }
        String referer = request.getHeader("referer");
        return new ActionForward(referer, true);
    }
}