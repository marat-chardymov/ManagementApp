<%@ include file="includes/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management App</title>
    <meta charset="utf-8">
    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/editNews.css" rel="stylesheet">
    <link href="css/lib/datepicker3.css" rel="stylesheet">

    <script src="js/lib/jquery-1.11.0.min.js"
            type="text/javascript"></script>
    <script src="js/lib/bootstrap-datepicker.js"></script>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    News management
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
                                <li><a href="${pageContext.request.contextPath}/newsList.do">News List</a></li>
                                <li class="active"><a href="addAndEditNews.jsp">Add news</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-9 column">
                        <html:form action="/addNews?id=${param.id}" styleClass="form-horizontal">
                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">Title</label>

                                <div class="col-sm-8">
                                    <html:text property="title" styleId="title"
                                               styleClass="form-control" value="${newsForm.title}"></html:text>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="date" class="col-sm-2 control-label">Date</label>

                                <div class="col-sm-8">
                                    <html:text property="date" styleId="date"
                                               styleClass="datepicker" value="${newsForm.date}"></html:text>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="brief" class="col-sm-2 control-label">Brief</label>

                                <div class="col-sm-8">
                                    <html:textarea property="brief" styleId="brief" styleClass="form-control" value="${newsForm.brief}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="content" class="col-sm-2 control-label">Content</label>

                                <div class="col-sm-8">
                                    <html:textarea property="content" styleId="content" styleClass="form-control" value="${newsForm.content}"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-6">
                                    <html:submit styleClass="btn btn-primary"><bean:message key="buttons.save"/></html:submit>
                                    <a href="${pageContext.request.contextPath}/newsList.do" class="btn btn-default">Cancel</a>
                                </div>
                            </div>


                        </html:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <html:errors/>
    <div class="row">
        <div class="col-md-12 column">
            © 1993-2014. EPAM Systems. All Rights Reserved.
        </div>
    </div>

</div>
<script src="js/addNews.js"></script>
</body>
</html>
