<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>
<div class="col-md-9 column " id="content">
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.title"/></label>

        <div class="col-md-10">
            ${newsForm.news.title}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.date"/></label>

        <div class="col-md-10">
            ${newsForm.news.createdAt}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.brief"/></label>

        <div class="col-md-10">
            ${newsForm.news.brief}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.content"/></label>

        <div class="col-md-10">
            ${newsForm.news.content}
        </div>
    </div>
    <br>

    <div>
        <html:link action="/NewsAction.do?action=edit&id=${param.id}" styleClass="btn btn-primary"><bean:message key="buttons.edit"/></html:link>
        <html:link action="/NewsAction.do?action=delete&id=${param.id}" styleClass="btn btn-primary" styleId="deleteBtn"><bean:message key="buttons.delete"/></html:link>
    </div>

</div>

<%-- switch js to appropriate localized version --%>
<% if(((Locale)request.getSession().getAttribute("org.apache.struts.action.LOCALE")).getLanguage().equals("ru")){ %>
<%="<script src='js/viewNews_ru.js'></script>" %>
<% }else{ %>
<%=" <script src='js/viewNews.js'></script>" %>
<% } %>