<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.01.2015
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20.01.2015
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
  <title>Sample Form</title>
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<div id="container">

  <h2>Add user.</h2>
  <c:if test="${not empty message}"><div class="message green">${message}</div></c:if>

  <form:form action="/user/form" modelAttribute="userForm">
    <label for="nameInput">Name: </label>
    <form:input path="name" id="nameInput" /> <br/>
    <form:errors path="name" cssClass="error" />
    <br/>

    <label for="passwordInput">Password: </label>
    <form:password path="password" id="passwordInput" /> <br/>
    <form:errors path="password" cssClass="error" />
    <br/>

    <label for="birthDateInput">Birthday: </label>
    <form:input path="birthDate" id="birthDateInput" placeholder="MM/DD/YYYY" /> <br/>
    <form:errors path="birthDate" cssClass="error" />
    <br/>

    <br/>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="submit" value="Submit" />
  </form:form>
</div>

</body>
</html>