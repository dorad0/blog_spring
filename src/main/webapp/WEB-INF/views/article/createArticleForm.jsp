<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true" %>
<html>
<head>
    <title>Add article page</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/login.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
</head>
<body onload='document.articleForm.title.focus();'>
<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-6 col-md-offset-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><spring:message code="article.create"/></h3>
                </div>
                <div class="panel-body">
                    <form:form accept-charset="UTF-8" name="articleForm" action="/article/form" method="post" modelAttribute="articleForm">
                        <fieldset>
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
                            <div class="form-group">
                                <spring:message var="Title" code="article.title"/>
                                <form:input path="title" id="title" cssClass="form-control" placeholder="${Title}"/>
                                <%--<input class="form-control" placeholder="Title" name="title" type="text">--%>
                                <form:errors path="title" cssClass="has-error"/>
                            </div>
                            <div class="form-group">
                                <spring:message var="Text" code="article.text"/>
                                <textarea class="form-control" rows="15" placeholder="${Text}" name="text" type="text"
                                       value=""></textarea>
                                <form:errors path="text" cssClass="has-error"/>
                            </div>
                                <sec:authentication var="userName" property="principal.username" />
                                <input name="userName" type="hidden" value="${userName}"/>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                                <spring:message var="addButtonValue" code="article.add"/>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="${addButtonValue}">
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
