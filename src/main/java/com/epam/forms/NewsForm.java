package com.epam.forms;

import com.epam.model.entities.News;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class NewsForm extends ActionForm {

    private News news = new News();
    private List<News> newsList = new ArrayList<News>();
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

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
//        // reset properties
//        if (news != null) {
//            this.news.setTitle("");
//            this.news.setCreatedAt(null);
//            this.news.setBrief("");
//            this.news.setContent("");
//        }
    }

}
