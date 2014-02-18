<%@ include file="includes/libs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>Management App</title>
    <meta charset="utf-8">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/editNews.css" rel="stylesheet">
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
                        <form method="post" action="" role="form" class="form-horizontal">
                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">Title</label>
                                <div class="col-sm-8">
                                    <input type="text" id="title" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="date" class="col-sm-2 control-label">Date</label>
                                <div class="col-sm-8">
                                    <input type="text" id="date" class="form-control">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="brief" class="col-sm-2 control-label">Brief</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" id="brief" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="content" class="col-sm-2 control-label">Content</label>
                                <div class="col-sm-8">
                                    <textarea class="form-control" id="content" rows="3"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-6">
                                    <button type="submit" class="btn btn-primary">Save</button>
                                    <button type="submit" class="btn btn-default">Cancel</button>
                                </div>
                            </div>

                        </form>

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
