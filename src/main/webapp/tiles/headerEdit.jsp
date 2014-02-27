<%@ include file="/tiles/libs.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

    <link href="css/editNews.css" rel="stylesheet">
    <link href="css/lib/datepicker3.css" rel="stylesheet">

    <script src="js/lib/date-picker/bootstrap-datepicker.js"></script>
    <html:base/>

<div class="container">
    <div class="row">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <bean:message key="header.title"/>
                    <div class="locale">
                        <h4><html:link page="/locale.do?method=english">English</html:link>
                            <html:link page="/locale.do?method=russian">Русский</html:link>
                        </h4>
                    </div>
                </h1>
            </div>
        </div>
    </div>