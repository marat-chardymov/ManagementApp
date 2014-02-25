<%@ include file="/tiles/libs.jsp" %>
<div class="col-md-9 column " id="content">
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.title"/></label>

        <div class="col-md-10">
            ${newsForm.title}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.date"/></label>

        <div class="col-md-10">
            ${newsForm.date}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.brief"/></label>

        <div class="col-md-10">
            ${newsForm.brief}
        </div>
    </div>
    <br>
    <div class="row">
        <label class="col-md-2"><bean:message key="newsPage.content"/></label>

        <div class="col-md-10">
            ${newsForm.content}
        </div>
    </div>
    <br>

    <div>
        <a href="${pageContext.request.contextPath}/newsList.do" class="btn btn-default"><bean:message key="buttons.backToList"/></a>
        <html:link action="/editNews?id=${param.id}" styleClass="btn btn-primary"><bean:message key="buttons.edit"/></html:link>
        <html:link action="/NewsAction.do?action=delete&id=${param.id}" styleClass="btn btn-primary"><bean:message key="buttons.delete"/></html:link>
    </div>

</div>
