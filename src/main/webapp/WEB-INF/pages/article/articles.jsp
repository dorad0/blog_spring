<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.01.2015
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All articles</title>
</head>
<body>

  <c:forEach var="article" items="${articles}">
    <c:out value="${article.title}"/>
  </c:forEach>


</body>
</html>
