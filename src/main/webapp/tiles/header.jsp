<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

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
