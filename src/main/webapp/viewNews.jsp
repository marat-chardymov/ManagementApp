<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<tiles:insert definition="news-template" >
    <tiles:put name="header" value="/tiles/headerEdit.jsp" />
    <tiles:put name="body" value="/tiles/news/bodies/viewNewsBody.jsp" />
</tiles:insert>
