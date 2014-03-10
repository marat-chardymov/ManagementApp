<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

    <link href="${pageContext.request.contextPath}/css/editNews.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/lib/datepicker3.css" rel="stylesheet">
    <html:base/>

<div id="header_title">
    <bean:message key="header.title"/>
</div>


<table id="locale">
    <tr>
        <td>
            <html:link page="/locale.do?loc=en">English</html:link>
        </td>
        <td>
            <html:link page="/locale.do?loc=ru">Русский</html:link>
        </td>
    </tr>
</table>