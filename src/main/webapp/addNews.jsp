<%@ include file="includes/libs.jsp" %>
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
                                <li class="active"><a href="addNews.jsp">Add news</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-9 column">
                        <html:form action="/addNews" styleClass="form-horizontal">
                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">Title</label>

                                <div class="col-sm-8">
                                    <html:text property="title" styleId="title"
                                               styleClass="form-control"></html:text>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="date" class="col-sm-2 control-label">Date</label>

                                <div class="col-sm-8">
                                    <html:text property="date" styleId="date"
                                               styleClass="datepicker"></html:text>
                                        <%--<input type="text" id="date" value="${date}" class="form-control">--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="brief" class="col-sm-2 control-label">Brief</label>

                                <div class="col-sm-8">
                                    <html:textarea property="brief" styleId="brief" styleClass="form-control"/>
                                        <%--<textarea class="form-control" id="brief" rows="3"></textarea>--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="content" class="col-sm-2 control-label">Content</label>

                                <div class="col-sm-8">
                                    <html:textarea property="content" styleId="content" styleClass="form-control"/>
                                        <%--<textarea class="form-control" id="content" rows="3"></textarea>--%>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-6">
                                    <html:submit styleClass="btn btn-primary" value="Save"/>
                                    <a href="${pageContext.request.contextPath}/newsList.do" class="btn btn-default">Cancel</a>
                                </div>
                            </div>


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
<script src="js/addNews.js"></script>
</body>
</html>
