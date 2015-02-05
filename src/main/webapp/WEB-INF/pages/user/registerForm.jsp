<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.01.2015
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Register user</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
</head>
<body>

<div class="container center-block">
    <%--<c:if test="${not empty message}">--%>
        <%--<div class="message green">${message}</div>--%>
    <%--</c:if>--%>

    <form:form cssClass="form-horizontal" action="/user/form" modelAttribute="userForm" method="post">
        <fieldset>
            <div id="legend">
                <legend class="">Register user</legend>
            </div>

            <div class="control-group">
                <!--Username-->
                <label class="control-label" for="nameInput">Name: </label>

                <div class="input-group">
                    <form:input path="name" id="nameInput" cssClass="form-control" /> <br>
                    <form:errors path="name" cssClass="has-error"/>
                </div>

            </div>

            <div class="control-group">
                <!--Password-->
                <label class="control-label" for="passwordInput">Password: </label>

                <div class="controls">
                    <input id="passwordInput" name="password" class="password-field" type="password" value=""> <br>
                    <form:errors path="password" cssClass="has-error"/>
                </div>
            </div>

            <div class="control-group">
                <!--BirthDate-->
                <label class="control-label" for="birthDateInput">BirthDate: </label>

                <div class="controls">
                    <form:input path="birthDate" id="birthDateInput" cssClass="date-cell"/> <br>
                    <form:errors path="birthDate" cssClass="has-error"/>
                </div>
            </div>

            <br>
            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success" type="submit">Register</button>
                </div>
            </div>
        </fieldset>
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form:form>
</div>

</body>
</html>