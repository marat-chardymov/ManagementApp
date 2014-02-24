<%@ include file="/tiles/libs.jsp" %>
<div class="col-md-9 column">
    <html:form action="/deleteNewsList">
        <c:forEach items="${newsList}" var="news">
            <div>
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
                    <html:link action="/viewNews?id=${news.id}"><bean:message key="links.view"/></html:link>
                    <html:link action="/editNews?id=${news.id}"><bean:message key="links.edit"/></html:link>
                    <html:multibox property="selectedItems" value="${news.id}"/>
                </div>
            </div>
        </c:forEach>
        <html:submit styleClass="btn btn-primary"><bean:message key="buttons.delete"/></html:submit>
    </html:form>
</div>