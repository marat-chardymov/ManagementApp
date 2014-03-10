<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>

<link href="${pageContext.request.contextPath}/css/viewNews.css" rel="stylesheet">

<div class="breadcrumb"><a href="/newsAction.do?method=list"><bean:message
        key="breadcrumb.news"/></a>>><bean:message
        key="breadcrumb.newsView"/>
</div>
<table id="view">
    <tr>
        <td>
            <label class="in"><bean:message key="newsPage.title"/></label>
        </td>
        <td>
            ${newsForm.news.title}
        </td>
    </tr>
    <tr>
        <td>
            <label class="in"><bean:message key="newsPage.date"/></label>
        </td>
        <td>
            <fmt:formatDate value="${newsForm.news.createdAt}" pattern="dd/MM/yyyy"/>
        </td>
    </tr>
    <tr>
        <td valign="top">
            <label class="in"><bean:message key="newsPage.brief"/></label>
        </td>
        <td>
            ${newsForm.news.brief}
        </td>
    </tr>
    <tr>
        <td valign="top">
            <label class="in"><bean:message key="newsPage.content"/></label>
        </td>
        <td>
            ${newsForm.news.content}
        </td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <div id="buttons">
                <html:link action="NewsAction.do?action=edit" styleClass="btnLink" style="text-decoration: none;">
                    <bean:message key="buttons.edit"/></html:link>
                <html:link action="NewsAction.do?action=delete" styleClass="btnLink">
                    <bean:message key="buttons.delete"/></html:link>
            </div>
        </td>
    </tr>
</table>
<br>


<%-- localize_js.jsp contains localization variables --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/localize_js.jsp"></script>

<script src='${pageContext.request.contextPath}/js/viewNews/viewNews.js'></script>
