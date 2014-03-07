<%@ page import="java.util.Locale" %>
<%@ include file="/tiles/libs.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/lib/bootstrap.min.css"/>
    <html:form action="/NewsAction.do?action=save" styleClass="form-horizontal" styleId="newsForm">
        <html:hidden property="news.id" name="newsForm" value="${newsForm.news.id}"/>
        <%-- title--%>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label"><bean:message
                    key="newsPage.title"/></label>

            <div class="col-sm-8">
                    <%-- title input --%>
                <html:text property="news.title" styleId="title"
                           value="${newsForm.news.title}"/>
            </div>
        </div>
        <%-- date--%>
        <div class="form-group">
            <label for="date" class="col-sm-2 control-label"><bean:message
                    key="newsPage.date"/></label>

            <div class="col-sm-8">
                    <%-- date input --%>
                <html:text property="news.createdAt" styleId="date"
                           styleClass="datepicker" value="${newsForm.news.createdAt}"/>
            </div>
        </div>
        <%-- brief --%>
        <div class="form-group">
            <label for="brief" class="col-sm-2 control-label"><bean:message
                    key="newsPage.brief"/></label>

            <div class="col-sm-8">
                    <%-- brief textarea --%>
                <html:textarea property="news.brief" styleId="brief" name="brief"
                               value="${newsForm.news.brief}"/>
            </div>
        </div>
        <%-- content --%>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label"><bean:message
                    key="newsPage.content"/></label>

            <div class="col-sm-8">
                    <%-- content textarea --%>
                <html:textarea property="news.content" styleId="content"
                               value="${newsForm.news.content}" rows="10"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <html:submit ><bean:message
                        key="buttons.save"/></html:submit>
                <button onclick="javascript:history.back();return false;">
                    <bean:message key="buttons.cancel"/>
                </button>
            </div>
        </div>
    </html:form>

<script src="${pageContext.request.contextPath}/js/lib/date-picker/bootstrap-datepicker.js"></script>
<%-- localize_js.jsp contains localization messages for validation and datepicker --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/localize_js.jsp"></script>
<script src='${pageContext.request.contextPath}/js/lib/date-picker/bootstrap-datepicker.ru.js'></script>

<script src="${pageContext.request.contextPath}/js/editNews/news.js"></script>




                