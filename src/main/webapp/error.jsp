<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%-- above we include all necessary tag librarise --%>
<html>
<head>
    <title><bean:message key="errorPage.title"/></title>
    <link href="<%=request.getContextPath()%>/css/lib/bootstrap.min.css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/404.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <h1>
            <bean:message key="errorPage.header"/>
        </h1>

        <p>
            <bean:message key="errorPage.content"/>
        </p>

        <p>
            <a href="<%=request.getContextPath()%>" class="btn btn-primary btn-large"><bean:message
                    key="errorPage.backToHome"/> »</a>
        </p>
    </div>
    <hr>
    <footer>
        <p>
            Copyright © 2014. EPAM Systems. All Rights Reserved.
        </p>
    </footer>
</div>
</body>
</html>