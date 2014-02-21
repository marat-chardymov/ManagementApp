<%@ include file="includes/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management App</title>
    <meta charset="utf-8">
    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/viewNews.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <bean:message key="header.title"/>
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
                                <li><a href="${pageContext.request.contextPath}/newsList.do"><bean:message key="menu.newsList"/></a></li>
                                <li><a href="addAndEditNews.jsp"><bean:message key="menu.addNews"/></a></li>
                            </ul>
                        </nav>
                    </div>
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
                            <html:link action="/deleteNews?id=${param.id}" styleClass="btn btn-primary"><bean:message key="buttons.delete"/></html:link>
                        </div>

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
