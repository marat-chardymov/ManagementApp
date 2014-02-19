package com.epam.action.util;

import com.epam.forms.NewsForm;
import com.epam.model.entities.News;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Marat_Chardymau on 2/19/14.
 */
public class NewsConverter {
    public static void NewsToForm(NewsForm form, News news) {
        form.setTitle(news.getTitle());
        form.setBrief(news.getBrief());
        form.setContent(news.getContent());

        DateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dFormat.format(news.getCreatedAt());
        form.setDate(strDate);
    }
}
