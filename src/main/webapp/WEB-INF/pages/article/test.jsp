<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12.03.2015
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:forEach var="article" items="${articles}">
${article.title}
    </c:forEach>

</body>
</html>
