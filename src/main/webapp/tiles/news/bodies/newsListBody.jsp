<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<link href="css/newsList.css" rel="stylesheet">

<div class="col-md-9 column">
    <html:form action="/NewsAction.do?action=deleteList" styleId="newsForm">
        <c:forEach items="${newsForm.newsList}" var="news">
            <div class="newsBlock">
                <span>
                    <h2 class="title">
                            ${news.title}
                    </h2>

                    <span class="date">
                        <fmt:formatDate value="${news.createdAt}" pattern="dd-MM-yyyy"/>
                    </span>
                </span>

                <p class="brief">
                        ${news.brief}
                </p>

                <div class="RUDbuttons">
                    <bean:define id="id" property="news.id" value="${news.id}"/>
                    <html:link action="NewsAction.do?action=view" paramId="news.id"
                               paramName="id">
                        <bean:message key="links.view"/>
                    </html:link>
                    <html:link action="NewsAction.do?action=edit" paramId="news.id"
                               paramName="id">
                        <bean:message key="links.edit"/>
                    </html:link>
                    <html:multibox property="selectedItems" value="${news.id}"/>
                </div>
            </div>
        </c:forEach>
        <html:submit styleClass="btn btn-primary" styleId="deleteBtn"><bean:message key="buttons.delete"/></html:submit>
    </html:form>
</div>
<%-- localize_js.jsp contains localization variables --%>
<script type="text/javascript" src="js/localize_js.jsp"></script>
<script src='js/newsList/newsList.js'></script>
