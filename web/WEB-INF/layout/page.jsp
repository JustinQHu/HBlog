<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<%--
  Created by IntelliJ IDEA.
  User: alpha
  Date: 10/16/2017
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> <s:message code="welcome" /></title>
    <link rel="stylesheet"
          type="text/css"
          href="<s:url value="/resources/style.css" />" />
</head>
<body>
    <div id="header">
        <tiles:insertAttribute name="header" />
    </div>

    <div id="content">
        <tiles:insertAttribute name="body"/>
    </div>

    <div id="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</body>
</html>
