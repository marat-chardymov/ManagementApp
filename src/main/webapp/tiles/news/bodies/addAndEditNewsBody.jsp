<%@ include file="/tiles/libs.jsp" %>
<div class="col-md-9 column">
    <html:form action="/NewsAction.do?action=save&id=${param.id}" styleClass="form-horizontal">
        <%-- title--%>
        <div class="form-group">
            <label for="title" class="col-sm-2 control-label"><bean:message
                    key="newsPage.title"/></label>

            <div class="col-sm-8">
                <%--title error message--%>
                <logic:messagesPresent property="title">
                    <div class="alert alert-danger">
                        <html:messages id="err_title" property="title">
                            <bean:write name="err_title"/>
                            <br/>
                        </html:messages>
                    </div>
                </logic:messagesPresent>
                <%-- title input --%>
                <html:text property="title" styleId="title"
                           styleClass="form-control" value="${newsForm.title}"></html:text>
            </div>
        </div>
        <%-- date--%>
        <div class="form-group">
            <label for="date" class="col-sm-2 control-label"><bean:message
                    key="newsPage.date"/></label>

            <div class="col-sm-8">
                <%--date error message--%>
                <logic:messagesPresent property="date">
                    <div class="alert alert-danger">
                        <html:messages id="err_date" property="date">
                            <bean:write name="err_date"/>
                            <br/>
                        </html:messages>
                    </div>
                </logic:messagesPresent>
                <%-- date input --%>
                <html:text property="date" styleId="date"
                           styleClass="datepicker" value="${newsForm.date}"></html:text>
            </div>
        </div>
        <%-- brief --%>
        <div class="form-group">
            <label for="brief" class="col-sm-2 control-label"><bean:message
                    key="newsPage.brief"/></label>

            <div class="col-sm-8">
                <%--brief error message--%>
                <logic:messagesPresent property="brief">
                    <div class="alert alert-danger">
                        <html:messages id="err_brief" property="brief">
                            <bean:write name="err_brief"/>
                            <br/>
                        </html:messages>
                    </div>
                </logic:messagesPresent>
                <%-- brief textarea --%>
                <html:textarea property="brief" styleId="brief" styleClass="form-control"
                               value="${newsForm.brief}"/>
            </div>
        </div>
        <%-- content --%>
        <div class="form-group">
            <label for="content" class="col-sm-2 control-label"><bean:message
                    key="newsPage.content"/></label>

            <div class="col-sm-8">
                <%--content error message--%>
                <logic:messagesPresent property="content">
                    <div class="alert alert-danger">
                        <html:messages id="err_content" property="content">
                            <bean:write name="err_content"/>
                            <br/>
                        </html:messages>
                    </div>
                </logic:messagesPresent>
                <%-- content textarea --%>
                <html:textarea property="content" styleId="content" styleClass="form-control"
                               value="${newsForm.content}"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-6">
                <html:submit styleClass="btn btn-primary"><bean:message
                        key="buttons.save"/></html:submit>
                <a href="${pageContext.request.contextPath}/newsList.do"
                   class="btn btn-default"><bean:message key="buttons.cancel"/></a>
            </div>
        </div>


    </html:form>
</div>
<script src="js/addNews.js"></script>
                