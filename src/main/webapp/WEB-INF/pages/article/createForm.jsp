<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.01.2015
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create article</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
<sf:form action="/article/form" method="post" commandName="article">
    <sf:label path="title" cssErrorClass="error">Title</sf:label>
    <sf:input path="title" cssErrorClass="error"/> <br>

    <sf:label path="text" cssErrorClass="error">Article body</sf:label>
    <sf:textarea path="text" cssErrorClass="error"/>

    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="submit" value="Submit" />
</sf:form>
</body>
</html>
