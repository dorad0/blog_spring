<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 14.02.2015
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="../head.jsp"/>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="blog-header">
        <h1 class="blog-title">The Blog</h1>

        <p class="lead blog-description">The official blog.</p>
    </div>
    <div class="row">
        <div class="col-sm-8 blog-main">
            <p>
                Article with title: ${article.title} was deleted.
            </p>
            <p>
                <a href="/article/">Go back</a>
            </p>
        </div>
        <jsp:include page="../sidebar.jsp"/>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>