<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<tiles:insert definition="news-template" >
    <tiles:put name="body" value="/tiles/news/bodies/newsListBody.jsp" />
</tiles:insert>