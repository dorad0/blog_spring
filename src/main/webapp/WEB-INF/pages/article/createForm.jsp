<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28.01.2015
  Time: 7:21
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true" %>
<html xmlns:th="http://www.thymeleaf.org" xmlns:tiles="http://www.thymeleaf.org">
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
                    <h3 class="panel-title">Please enter your article</h3>
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
                                <form:input path="title" id="title" cssClass="form-control" placeholder="Title"/>
                                <%--<input class="form-control" placeholder="Title" name="title" type="text">--%>
                                <form:errors path="title" cssClass="has-error"/>
                            </div>
                            <div class="form-group">
                                <textarea class="form-control" rows="15" placeholder="Article text" name="text" type="text"
                                       value=""></textarea>
                                <form:errors path="text" cssClass="has-error"/>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Add article">
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
