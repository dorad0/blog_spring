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
    <link rel="icon" href="../resources/fonts/favicon.ico">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/resources/css/blog.css"/>"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>
<body>

<div class="container">
    <%--<c:if test="${not empty message}">--%>
    <%--<div class="message green">${message}</div>--%>
    <%--</c:if>--%>
    <div class="row">
        <form:form cssClass="form-horizontal" action="/user/form" modelAttribute="userForm" method="post">
            <fieldset>
                <div id="legend">
                    <legend class="">Register user</legend>
                </div>

                <div class="form-group">
                    <!--Username-->
                    <label class="control-label" for="nameInput">Name: </label>
                    <div class="input-group">
                        <form:input path="name" id="nameInput" cssClass="form-control"/> <br>
                        <form:errors path="name" cssClass="has-error"/>
                    </div>

                </div>

                <div class="form-group">
                    <!--Password-->
                    <label class="control-label" for="passwordInput">Password: </label>
                    <div class="input-group">
                        <form:password path="password" id="passwordInput" cssClass="form-control"/> <br>
                        <form:errors path="password" cssClass="has-error"/>
                    </div>
                </div>

                <div class="form-group">
                    <!--BirthDate-->
                    <label class="control-label" for="birthDateInput">BirthDate: </label>

                    <div class="input-group">
                        <form:input path="birthDate" id="birthDateInput" cssClass="form-control"/> <br>
                        <form:errors path="birthDate" cssClass="has-error"/>
                    </div>
                </div>

                <br>

                <div class="form-group">
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control"/>
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                </div>
                <script type="text/javascript">
                    $(document).ready(function () {
                        $(function () {
                            $('#datetimepicker1').datetimepicker({
                                pickTime: false
                            });
                        });
                    })

                </script>


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
</div>

</body>
</html>