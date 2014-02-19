<%@ include file="includes/libs.jsp" %>
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
                                <li><a href="addAndEditNews.jsp">Add news</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-9 column " id="content">
                        <div class="row">
                            <label class="col-md-2">Title</label>

                            <div class="col-md-10">
                                ${newsForm.title}
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <label class="col-md-2">Date</label>

                            <div class="col-md-10">
                                ${newsForm.date}
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <label class="col-md-2">Brief</label>

                            <div class="col-md-10">
                                ${newsForm.brief}
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <label class="col-md-2">Content</label>

                            <div class="col-md-10">
                                ${newsForm.content}
                            </div>
                        </div>
                        <br>

                        <div>
                            <a href="${pageContext.request.contextPath}/newsList.do" class="btn btn-default">Back to
                                news list</a>
                            <html:link action="/editNews?id=${param.id}" styleClass="btn btn-primary">Edit</html:link>
                            <html:link action="/deleteNews?id=${param.id}" styleClass="btn btn-primary">Delete</html:link>
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
