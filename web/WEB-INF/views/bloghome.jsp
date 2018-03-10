<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: huqijun
  Date: 10/14/2017
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!--article list -->
<div class="outer"  >
    <ul class="list-group">
        <c:forEach items="${articleDescriptionList}" var="articleDescription" >
            <li class="list-group-item title">
                <a href="/blog/<c:out value="${articleDescription.publishDate}" />/<c:out value="${articleDescription.tag}" /> "> <c:out value="${articleDescription.articleName}" /> </a></br>
            </li>
        </c:forEach>
    </ul>
</div>


