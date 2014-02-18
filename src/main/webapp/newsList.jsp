<%@ include file="includes/libs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management App</title>
    <meta charset="utf-8">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/newsList.css" rel="stylesheet">
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
                                <li class="active"><a href="#">News List</a></li>
                                <li><a href="addNews.jsp">Add news</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="col-md-9 column">
                        <html:form action="/deleteNews">
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
                                        <a class="btn" href="#">View</a>
                                        <a class="btn" href="#">Edit</a>
                                        <html:multibox property="selectedItems" value="${news.id}"/>
                                    </div>
                                </div>
                            </c:forEach>
                            <html:submit styleClass="btn btn-primary" value="delete"/>
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