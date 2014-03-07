<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>


<div id="sidebar">
    <div id="sidebar_title">
        <div>News</div>
    </div>
    <div id="nav_list">
        <ul>
            <li ${pageContext.request.queryString.contains('list') ? 'class="active"':""} >
                <a href="${pageContext.request.contextPath}/NewsAction.do?action=list"><bean:message
                        key="menu.newsList"/></a>
            </li>
            <li ${pageContext.request.queryString.contains('add') ? 'class="active"':""} >
                <a href="${pageContext.request.contextPath}/NewsAction.do?action=add"><bean:message
                        key="menu.addNews"/></a>
            </li>
        </ul>
    </div>
</div>


