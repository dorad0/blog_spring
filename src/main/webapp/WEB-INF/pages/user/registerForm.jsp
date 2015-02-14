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
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/blog.css"/>
    <link rel="stylesheet" href="/resources/css/datepicker.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="/resources/js/bootstrap-datepicker.js"></script>

    <%--<link href="/resources/css/bootstrap.min.css" rel="stylesheet">--%>
    <%--<link href="/resources/css/login.css" rel="stylesheet">--%>
    <%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>--%>
    <%--<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>--%>
</head>
<body>

<%--<body onload='document.loginForm.username.focus();'>--%>
<%--<div class="container">--%>
<%--<div class="row vertical-offset-100">--%>
<%--<div class="col-md-4 col-md-offset-4">--%>
<%--<div class="panel panel-default">--%>
<%--<div class="panel-heading">--%>
<%--<h3 class="panel-title">Please sign in</h3>--%>
<%--</div>--%>
<%--<div class="panel-body">--%>
<%--<form accept-charset="UTF-8" name="loginForm" role="form" action="/login" method="post">--%>
<%--<fieldset>--%>
<%--<c:if test="${not empty error}">--%>
<%--<div class="alert alert-warning">--%>
<%--<c:out value="${error}"/>--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty logout}">--%>
<%--<div class="alert alert-success">--%>
<%--<c:out value="${logout}"/>--%>
<%--</div>--%>
<%--</c:if>--%>
<%--<div class="form-group">--%>
<%--<input class="form-control" placeholder="Name" name="username" type="text">--%>
<%--</div>--%>
<%--<div class="form-group">--%>
<%--<input class="form-control" placeholder="Password" name="password" type="password"--%>
<%--value="">--%>
<%--</div>--%>
<%--<div class="checkbox">--%>
<%--<label>--%>
<%--<input name="remember" type="checkbox" value="Remember Me"> Remember Me--%>
<%--</label>--%>
<%--</div>--%>
<%--<input type="hidden" name="${_csrf.parameterName}"--%>
<%--value="${_csrf.token}"/>--%>
<%--<input class="btn btn-lg btn-success btn-block" type="submit" value="Login">--%>
<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<script>--%>
<%--$(document).ready(function () {--%>
<%--$(document).mousemove(function (e) {--%>
<%--TweenLite.to($('body'),--%>
<%--.5,--%>
<%--{--%>
<%--css: {--%>
<%--backgroundPosition: "" + parseInt(event.pageX / 8) + "px " + parseInt(event.pageY / '12') + "px, " + parseInt(event.pageX / '15') + "px " + +parseInt(event.pageY / '15') + "px, " + parseInt(event.pageX / '30') + "px " + parseInt(event.pageY / '30') + "px"--%>
<%--}--%>
<%--});--%>
<%--});--%>
<%--});--%>
<%--</script>--%>


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
                    <label class="control-label" for="birthDateInput">Birthday: </label>

                    <div class="input-group">
                        <div class='input-group date' id='datetimepicker1'>
                            <form:input path="birthDate" id="birthDateInput" cssClass="form-control"/>
                            <form:errors path="birthDate" cssClass="has-error"/>
                        </div>
                    </div>
                </div>

                <br>

                <script>
                    $(document).ready(function () {

                        $('#birthDateInput').datepicker({
                            format: "dd/mm/yyyy"
                        });

                    });
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