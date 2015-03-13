<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.02.2015
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                No such article in the blog.
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
