<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alpha
  Date: 11/23/2017
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="inner">
<h4>2017.11.23  Version 0.1 Release:</h4>
<ol>
    <li>Basic feature of blog implemented, and change the blog template from <a href="https://hexo.io/">Hexo</a> to myOwn <a href=" <s:message code="HBlogAddr"/> ">HBlog</a>. </li>
    <li>Migrates <a href="http://huqijun.org">huqijun.org </a> from  <a href=" <s:message code="OldBlogAddr" /> ">GitHubPages</a> to own site. </li>
</ol>

<h4>2017.12.23 Version 0.2 Release:</h4>
<ol>
    <li>Optimize the mobile experiences using <a href="http://getbootstrap.com/">Bootstrap</a> .</li>
    <li>Redesign the UI of pages, offer a better looking of the blog.</li>
    <li>Add a navigate bar at top of blog.</li>
    <li>The blog detail page adds the display of article name. </li>
    <li>Add favicon for site. </li>
    <li>Bug Fixes:
        <ol>
           <li>Fix the bug of static resources(css/js/jpg) loading failure.</li>
        </ol>
    </li>
</ol>

<h4>2017.12.25 Version 0.3 Release:</h4>
<ol>
    <li>Add hope page.</li>
    <li>Implement the cache refresh feature that will periodically loading changes of blog.</li>
</ol>


<h5>Contribute to <a href=" <s:message code="HBlogAddr"/> ">HBlog</a> . </h5>
<h5>Contact Me:  <u><i><b> <s:message code="email" />  </b></i></u> </h5>
</div>

