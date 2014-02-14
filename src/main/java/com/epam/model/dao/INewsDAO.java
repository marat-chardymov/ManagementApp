package com.epam.model.dao;

import com.epam.model.entities.News;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Marat_Chardymau on 2/13/14.
 */
public interface INewsDAO {
    public void setDataSource(DataSource ds);
    public void save(News news) throws Exception;

}
