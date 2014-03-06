<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>

<link href="css/viewNews.css" rel="stylesheet">

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

    <div id="buttons">
        <bean:define id="id" property="news.id" value="${newsForm.news.id}"/>
        <html:link action="NewsAction.do?action=edit" paramId="news.id"
                   paramName="id" styleClass="btn btn-primary">
            <bean:message key="buttons.edit"/>
        </html:link>
        <html:link action="NewsAction.do?action=delete" paramId="news.id"
                   paramName="id" styleClass="btn btn-primary" styleId="deleteBtn">
            <bean:message key="buttons.delete"/>
        </html:link>
    </div>

</div>

<%-- localize_js.jsp contains localization variables --%>
<script type="text/javascript" src="js/localize_js.jsp"></script>

<script src='js/viewNews/viewNews.js'></script>
