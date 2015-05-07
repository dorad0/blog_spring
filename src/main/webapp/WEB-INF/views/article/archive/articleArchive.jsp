<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="col-sm-8 blog-main">
    <c:forEach var="article" items="${page.entities}">
        <div class="blog-post">
            <h2 class="blog-post-title">
                <a href="/comments/${article.id}/">${article.title}</a>
            </h2>

            <p class="blog-post-meta">
                <fmt:setLocale scope="session" value="en_US"/>
                <fmt:parseDate value="${article.publicationDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
                               var="parsedDate" type="both" />
                <fmt:formatDate type="both"
                                pattern="MMMMM d, yyyy"
                                value="${parsedDate}"/>
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
    </c:forEach>
    <nav>
        <ul class="pager">
            <c:if test="${page.previous}">
                <li><a href="/article/archive/${date.getYear()}/${date.getMonthValue()}/page/${page.previousPage}/">Previous</a>
                </li>
            </c:if>
            <c:if test="${page.next}">
                <li><a href="/article/archive/${date.getYear()}/${date.getMonthValue()}/page/${page.nextPage}/">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
