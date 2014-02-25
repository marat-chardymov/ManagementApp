package com.epam.action.util;

import com.epam.forms.NewsForm;
import com.epam.model.entities.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsConverter {
    public static void newsToForm(NewsForm form, News news) {
        form.setTitle(news.getTitle());
        form.setBrief(news.getBrief());
        form.setContent(news.getContent());

        DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dFormat.format(news.getCreatedAt());
        form.setDate(strDate);
    }
    public static News formToNews(NewsForm newsForm) throws ParseException {
        String title = newsForm.getTitle();
        String brief = newsForm.getBrief();
        String content = newsForm.getContent();
        String strDate = newsForm.getDate();
        //convert string with date to Date object
        DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dFormat.parse(strDate);
        return new News(title, brief, content, date);
    }
}
