<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="css/app.css" rel="stylesheet">

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
