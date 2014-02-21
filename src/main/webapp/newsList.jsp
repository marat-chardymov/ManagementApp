<%@ include file="includes/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management App</title>
    <meta charset="utf-8">

    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/newsList.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <bean:message key="header.title"/>
                    <div class="locale">
                        <h4><html:link page="/locale.do?method=english">English</html:link>
                            <html:link page="/locale.do?method=russian">Russian</html:link>
                        </h4>
                    </div>
                </h1>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 column">
                <div class="row">
                    <div class="col-md-3 column">
                        <nav>
                            <ul class="nav nav-pills nav-stacked span2">
                                <li class="active"><a href="#"><bean:message key="menu.newsList"/></a></li>
                                <li><a href="addAndEditNews.jsp"><bean:message key="menu.addNews"/></a></li>
                            </ul>
                        </nav>
                    </div>
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
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 column">
            © 1993-2014. EPAM Systems. All Rights Reserved.
        </div>
    </div>

</div>
</body>
</html>