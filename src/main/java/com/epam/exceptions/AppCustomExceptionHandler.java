package com.epam.exceptions;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppCustomExceptionHandler extends ExceptionHandler {

    private static final Logger logger =
            Logger.getLogger(AppCustomExceptionHandler.class);

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ec,
                                 ActionMapping mapping, ActionForm formInstance,
                                 HttpServletRequest request, HttpServletResponse response)
            throws ServletException {

        //log the error message
        logger.error(ex);

        return super.execute(ex, ec, mapping, formInstance, request, response);
    }
}