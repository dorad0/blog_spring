<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
<head>
    <title>Login Page</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
</head>
<body onload='document.loginForm.username.focus();'>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" name="loginForm" role="form" action="/login" method="post">
                        <fieldset>
                            <c:if test="${not empty error}">
                                <div class="alert alert-warning">
                                    <c:out value="${error}"/>
                                </div>
                            </c:if>
                            <c:if test="${not empty logout}">
                                <div class="alert alert-success">
                                    <c:out value="${logout}"/>
                                </div>
                            </c:if>
                            <div class="form-group">
                                <input class="form-control" placeholder="Name" name="username" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                                </label>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Login">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(document).mousemove(function (e) {
            TweenLite.to($('body'),
                    .5,
                    {
                        css: {
                            backgroundPosition: "" + parseInt(event.pageX / 8) + "px " + parseInt(event.pageY / '12') + "px, " + parseInt(event.pageX / '15') + "px " + +parseInt(event.pageY / '15') + "px, " + parseInt(event.pageX / '30') + "px " + parseInt(event.pageY / '30') + "px"
                        }
                    });
        });
    });
</script>

<%--<div id="login-box">--%>

<%--<h3>Login with Username and Password</h3>--%>

<%--<c:if test="${not empty error}">--%>
<%--<div class="error">${error}</div>--%>
<%--</c:if>--%>
<%--<c:if test="${not empty msg}">--%>
<%--<div class="msg">${msg}</div>--%>
<%--</c:if>--%>

<%--<form name='loginForm1'--%>

<%--action="<c:url value='/login' />" method='POST'>--%>

<%--<table>--%>
<%--<tr>--%>
<%--<td>User:</td>--%>
<%--<td><input type='text' name='username'></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td>Password:</td>--%>
<%--<td><input type='password' name='password'/></td>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<td colspan='2'><input name="submit" type="submit"--%>
<%--value="submit"/></td>--%>
<%--</tr>--%>
<%--</table>--%>


<%--</form>--%>
<%--</div>--%>

</body>
</html>