<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--<%@ page session="false" %>--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>--%>
<html>
<head>
    <title>Simple Blog</title>
    <link rel="icon" href="/resources/fonts/favicon.ico">
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/blog.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="/resources/js/html5shiv.min.js"></script>
    <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<tiles:insertAttribute name="menu"/>
<div class="container">
    <tiles:insertAttribute name="header"/>
    <div class="row">
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="sidebar"/>
    </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>