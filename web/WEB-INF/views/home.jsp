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

<!--navigate bar -->
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">  <s:message code="blogTitle"/>  </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#"> <s:message code="blog" /> <span class="sr-only">(current)</span></a></li>
                <li><a href=" <s:message code="weiboAddr" /> "   target="_blank"> <s:message code="weibo"/> </a></li>
                <li><a href="/pubaccout"> <s:message code="wechatPublicAccount" /> </a> </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> <s:message code="more" /> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/about"> <s:message code="aboutThisSite"/> </a></li>
                        <li><a href=" <s:message code="OldBlogAddr" /> "   target="_blank"> <s:message code="oldVersion"/> </a></li>
                    </ul>
                </li>

            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


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


