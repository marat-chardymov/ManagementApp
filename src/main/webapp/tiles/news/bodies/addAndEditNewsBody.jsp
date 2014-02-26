<%@ include file="/tiles/libs.jsp" %>
<div class="col-md-9 column">
    <html:form action="/NewsAction.do?action=save&id=${param.id}" styleClass="form-horizontal">
        <%-- title--%>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label"><bean:message
                    key="newsPage.title"/></label>

            <div class="col-sm-8">
                <%-- title input --%>
                <html:text property="news.title" styleId="title"
                           styleClass="form-control" value="${newsForm.news.title}"></html:text>
            </div>
        </div>
        <%-- date--%>
        <div class="form-group">
            <label for="date" class="col-sm-2 control-label"><bean:message
                    key="newsPage.date"/></label>

            <div class="col-sm-8">
                <%-- date input --%>
                <html:text property="news.createdAt" styleId="date"
                           styleClass="datepicker" value="${newsForm.news.createdAt}"></html:text>
            </div>
        </div>
        <%-- brief --%>
        <div class="form-group">
            <label for="brief" class="col-sm-2 control-label"><bean:message
                    key="newsPage.brief"/></label>

            <div class="col-sm-8">
                <%-- brief textarea --%>
                <html:textarea property="news.brief" styleId="brief" styleClass="form-control"
                               value="${newsForm.news.brief}"/>
            </div>
        </div>
        <%-- content --%>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label"><bean:message
                    key="newsPage.content"/></label>

            <div class="col-sm-8">
                <%-- content textarea --%>
                <html:textarea property="news.content" styleId="content" styleClass="form-control"
                               value="${newsForm.news.content}"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <html:submit styleClass="btn btn-primary"><bean:message
                        key="buttons.save"/></html:submit>
                <a href="${pageContext.request.contextPath}/NewsAction.do?action=list"
                   class="btn btn-default"><bean:message key="buttons.cancel"/></a>
            </div>
        </div>


    </html:form>
</div>
<script src="js/addNews.js"></script>
                