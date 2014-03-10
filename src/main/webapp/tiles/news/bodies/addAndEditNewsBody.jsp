<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>
<html:form action="/NewsAction.do?action=save" styleClass="form-horizontal" styleId="newsForm">
    <html:hidden property="news.id" name="newsForm" value="${newsForm.news.id}"/>
    <%-- title--%>
    <div class="form-group">
        <label for="title" class="in"><bean:message
                key="newsPage.title"/></label>

            <span class="inputField">
                    <%-- title input --%>
                <html:text property="news.title" styleId="title"
                           value="${newsForm.news.title}"/>
            </span>
    </div>
    <%-- date--%>
    <div class="form-group">
        <label for="date" class="in"><bean:message
                key="newsPage.date"/></label>

            <span class="inputField">
                    <%-- date input --%>
                <html:text property="news.createdAt" styleId="date"
                           styleClass="datepicker" value="${newsForm.news.createdAt}"/>
            </span>
    </div>
    <%-- brief --%>
    <div class="form-group">
        <label for="brief" id="briefLabel" class="in"><bean:message
                key="newsPage.brief"/></label>

            <span class="inputField">
                    <%-- brief textarea --%>
                <html:textarea property="news.brief" styleId="brief" name="brief"
                               value="${newsForm.news.brief}" rows="5"/>
            </span>
    </div>
    <%-- content --%>
    <div class="form-group">
        <label for="content" id="contentLabel" class="in"><bean:message
                key="newsPage.content"/></label>

            <span class="inputField">
                    <%-- content textarea --%>
                <html:textarea property="news.content" styleId="content"
                               value="${newsForm.news.content}" rows="10"/>
    </div>
    <div id="buttons">
        <html:submit><bean:message
                key="buttons.save"/></html:submit>
        <button onclick="javascript:history.back();return false;">
            <bean:message key="buttons.cancel"/>
        </button>
    </div>


</html:form>

<script src="${pageContext.request.contextPath}/js/lib/date-picker/bootstrap-datepicker.js"></script>
<%-- localize_js.jsp contains localization messages for validation and datepicker --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/localize_js.jsp"></script>
<script src='${pageContext.request.contextPath}/js/lib/date-picker/bootstrap-datepicker.ru.js'></script>

<script src="${pageContext.request.contextPath}/js/editNews/news.js"></script>




                