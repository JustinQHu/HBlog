<%--
  Created by IntelliJ IDEA.
  User: alpha
  Date: 11/22/2017
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="wrap">
   <h3> ${blogDetail.articleName}</h3>
</div>
<div class="inner">
   ${blogDetail.htmlContent}
</div>
