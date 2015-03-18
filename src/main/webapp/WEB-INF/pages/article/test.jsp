<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 12.03.2015
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<p class="lead blog-description">The official blog.</p>
</div>
<div class="row">
    <div class="col-sm-8 blog-main">
        <c:forEach var="article" items="${page.entities}">
            <div class="blog-post">
                <h2 class="blog-post-title">
                    <a href="/comments/${article.id}/">${article.title}</a>
                </h2>
                <p class="blog-post-meta">
                    <fmt:setLocale scope="session" value="en_US"/>
                    <fmt:formatDate value="${article.publicationDate.time}"
                                    pattern="MMMMM d, yyyy"/>
                    by <a
                        href="/user/<c:out value="${article.user.name}"/> "> <c:out
                        value="${article.user.name}"/> </a>
                </p>
                <p>
                        ${article.text}
                </p>
                <p>
                    <a href="/comments/${article.id}/">Read comments(${article.commentsCount})</a>
                </p>
                <sec:authorize ifAnyGranted="ROLE_ADMIN">
                    <form method="post" action="/article/delete?id=${article.id}">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                        <input type="submit" class="btn btn-lg btn-success" value="Delete"/>
                    </form>
                </sec:authorize>
            </div>
            <!-- /.blog-post -->
        </c:forEach>
        <nav>
            <ul class="pager">
                <c:if test="${page.previous}">
                    <li><a href="/article/page/${page.previousPage}/">Previous</a></li>
                </c:if>
                <c:if test="${page.next}">
                    <li><a href="/article/page/${page.nextPage}/">Next</a></li>
                </c:if>
            </ul>
        </nav>
    </div>

</body>
</html>
