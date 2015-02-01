<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.01.2015
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
  <c:out value="${user.name}"/> <br>
  <c:out value="${user.password}"/> <br>
  <%--<c:out value="${user.registrationDate}"/> <br>--%>
  <c:out value="${user.birthDate}"/>
</body>
</html>
