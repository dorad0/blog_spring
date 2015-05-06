<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-8 blog-main">
    <%--<c:forEach var="article" items="${page.entities}">--%>
        <%--<div class="blog-post">--%>
            <%--<h2 class="blog-post-title">--%>
                <%--<a href="/comments/${article.id}/">${article.title}</a>--%>
            <%--</h2>--%>

            <%--<p class="blog-post-meta">--%>
                <%--<fmt:setLocale scope="session" value="en_US"/>--%>
                <%--<fmt:formatDate value="${article.publicationDate.time}"--%>
                                <%--pattern="MMMMM d, yyyy"/>--%>
                <%--by <a--%>
                    <%--href="/user/${article.user.name}/">${article.user.name}</a>--%>
            <%--</p>--%>

            <%--<p>--%>
                <%--${article.text}--%>
            <%--</p>--%>

            <%--<p>--%>
                <%--<a href="/comments/${article.id}/">Read comments(${article.commentsCount})</a>--%>
            <%--</p>--%>
            <%--<sec:authorize ifAnyGranted="ROLE_ADMIN">--%>
                <%--<form method="post" action="/article/delete?id=${article.id}">--%>
                    <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                           <%--value="${_csrf.token}"/>--%>
                    <%--<input type="submit" class="btn btn-lg btn-success" value="Delete article"/>--%>
                <%--</form>--%>
            <%--</sec:authorize>--%>
        <%--</div>--%>
        <%--<!-- /.blog-post -->--%>
    <%--</c:forEach>--%>
    <%--<nav>--%>
        <%--<ul class="pager">--%>
            <%--<c:if test="${page.previous}">--%>
                <%--<li><a href="/article/page/${page.previousPage}/">Previous</a></li>--%>
            <%--</c:if>--%>
            <%--<c:if test="${page.next}">--%>
                <%--<li><a href="/article/page/${page.nextPage}/">Next</a></li>--%>
            <%--</c:if>--%>
        <%--</ul>--%>
    <%--</nav>--%>
</div>
