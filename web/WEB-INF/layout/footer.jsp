<%--
  Created by IntelliJ IDEA.
  User: alpha
  Date: 10/16/2017
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page import="java.time.Year" %>
<%
    int year = Year.now().getValue();
%>
<br/>
<br/>
<br/>
<div class="wrap">
    <b>Copyright &copy;<%=year%> <s:message code="DomainName" /> , All Rights Reserved</b>
</div>

