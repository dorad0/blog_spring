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
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <style>
    body { background-color: #eee; font: helvetica; }
    #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; }
    .green { font-weight: bold; color: green; }
    .message { margin-bottom: 10px; }
    label {width:70px; display:inline-block;}
    input { display:inline-block; margin-right: 10px; }
    form {line-height: 160%; }
    .hide { display: none; }
    .error { color: red; font-size: 0.9em; font-weight: bold; }
  </style>
</head>
<body>

<div id="container">

  <h2>Add user.</h2>
  <c:if test="${not empty message}"><div class="message green">${message}</div></c:if>

  <form:form action="/user/form" modelAttribute="user">
    <label for="nameInput">Name: </label>
    <form:input path="name" id="nameInput" />
    <form:errors path="name" cssClass="error" />
    <br/>

    <label for="passwordInput">Password: </label>
    <form:input path="password" id="passwordInput" />
    <form:errors path="password" cssClass="error" />
    <br/>

    <label for="birthdayInput">Birthday: </label>
    <form:input path="birthdayDate" id="birthdayInput" placeholder="MM/DD/YYYY" />
    <form:errors path="birthdayDate" cssClass="error" />
    <br/>

    <br/>
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
    <input type="submit" value="Submit" />
  </form:form>
</div>

</body>
</html>