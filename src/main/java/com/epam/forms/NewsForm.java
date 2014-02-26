package com.epam.forms;

import com.epam.model.entities.News;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class NewsForm extends ValidatorForm {

    private News news=new News();
    private int[] selectedItems;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public int[] getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(int[] selectedItems) {
        this.selectedItems = selectedItems;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
//        // reset properties
        this.news.setTitle("");
        this.news.setCreatedAt(null);
        this.news.setBrief("");
        this.news.setContent("");
////        this.news=null;
    }

}
