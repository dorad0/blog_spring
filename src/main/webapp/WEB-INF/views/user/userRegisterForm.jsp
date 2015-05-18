<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true" %>
<html>
<head>
    <title>Register user page</title>
    <!-- Bootstrap core CSS -->
    <link rel="icon" href="../resources/fonts/favicon.ico">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/blog.css"/>
    <link href="/resources/css/login.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/datepicker.css" rel="stylesheet">

    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/js/TweenLite.min.js"></script>
    <script src="/resources/js/bootstrap-datepicker.js"></script>
</head>
<body onload='document.loginForm.username.focus();'>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-lg-5 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="user.register"/></h3>
                </div>
                <div class="panel-body">
                    <form:form action="/user/form" modelAttribute="userForm" method="post">
                        <fieldset>
                            <div class="form-group">
                                <!--Username-->
                                <spring:message var="Name" code="user.name"/>
                                <input class="form-control" placeholder="${Name}" name="name" type="text"/>
                                <form:errors path="name" cssClass="has-error"/>
                            </div>
                            <div class="form-group">
                                <!--Password-->
                                <spring:message var="Password" code="user.password"/>
                                <input class="form-control" placeholder="${Password}" name="password" type="password"/>
                                <form:errors path="password" cssClass="has-error"/>
                            </div>
                            <div class="form-group">
                                <!--BirthDate-->
                                <div class="date" id="datetimepicker1">
                                    <spring:message var="BirhDate" code="user.birthDate"/>
                                    <form:input path="birthDate" id="birthDateInput" placeholder="${BirhDate}"
                                                cssClass="form-control"/>
                                    <form:errors path="birthDate" cssClass="has-error"/>
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
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <spring:message var="registerUserButtonValue" code="user.registerButton"/>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="${registerUserButtonValue}">
                        </fieldset>
                    </form:form>
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
</body>
</html>