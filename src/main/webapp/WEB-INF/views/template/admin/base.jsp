<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
  <title><tiles:insertAttribute name="title" ignore="true"/></title>
  <%--<meta name="description" content="<tiles:insertAttribute name="page_description" ignore="true"/>">--%>
  <link rel="icon" href="/resources/fonts/favicon.ico">
  <!-- Bootstrap core CSS -->
  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="/resources/css/admin_blog.css" rel="stylesheet">
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
    <div class="col-sm-8 blog-main">
      <tiles:insertAttribute name="body"/>
      <tiles:insertAttribute name="navbar"/>
    </div>
    <tiles:insertAttribute name="sidebar"/>
  </div>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>
