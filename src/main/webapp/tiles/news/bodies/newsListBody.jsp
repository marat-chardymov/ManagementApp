<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="col-md-9 column">
    <html:form action="/NewsAction.do?action=deleteList" styleId="newsForm">
        <c:forEach items="${newsForm.newsList}" var="news">
            <div class="newsBlock">
                <h2>
                        ${news.title}
                </h2>
                <span class="date">
                    <fmt:formatDate value="${news.createdAt}" pattern="dd-MM-yyyy"/>
                </span>

                <p>
                        ${news.brief}
                </p>

                <div class="RUDbuttons">
                    <html:link action="/NewsAction.do?action=view&id=${news.id}"><bean:message key="links.view"/></html:link>
                    <html:link action="/NewsAction.do?action=edit&id=${news.id}"><bean:message key="links.edit"/></html:link>
                    <html:multibox property="selectedItems" value="${news.id}" />
                </div>
            </div>
        </c:forEach>
        <html:submit styleClass="btn btn-primary"><bean:message key="buttons.delete"/></html:submit>
    </html:form>
</div>
<%-- switch js to appropriate localized version --%>
<% if(((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage().equals("ru")){ %>
<%="<script src='js/newsList_ru.js'></script>" %>
<% }else{ %>
<%=" <script src='js/newsList.js'></script>" %>
<% } %>