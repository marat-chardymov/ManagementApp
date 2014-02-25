<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<div class="container" id="bodyContainer">
    <div class="row">
        <div class="col-md-12 column">
            <div class="row">
                <div class="col-md-3 column">
                    <nav>
                        <ul class="nav nav-pills nav-stacked span2">
                            <li ${pageContext.request.requestURI.contains('newsList.jsp') ? 'class="active"':""} >
                                <a href="NewsAction.do?action=list"><bean:message key="menu.newsList"/></a>
                            </li>
                            <li ${pageContext.request.requestURI.contains('addAndEditNews.jsp') ? 'class="active"':""} >
                                <a href="NewsAction.do?action=add"><bean:message key="menu.addNews"/></a>
                            </li>
                        </ul>
                    </nav>
                </div>