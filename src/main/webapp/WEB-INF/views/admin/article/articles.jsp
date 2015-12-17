<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<c:forEach var="article" items="${page.entities}">
    <div class="blog-post">
        <h2 class="blog-post-title">
            <a href="/admin/comments/${article.id}/">${article.title}</a>
        </h2>
        <p class="blog-post-meta">
                <%--<fmt:setLocale scope="session" value="en_US"/>--%>
            <fmt:parseDate value="${article.publicationDate}" pattern="yyyy-MM-dd"
                           var="parsedDate" type="both"/>
            <fmt:formatDate type="both"
                            pattern="MMMMM d, yyyy"
                            value="${parsedDate}"/>
            <spring:message code="article.by"/> <a
                href="/admin/user/${article.user.name}/">${article.user.name}</a>
        </p>

        <p>
                ${article.text}
        </p>

        <p>
            <a href="/admin/comments/${article.id}/"><spring:message
                    code="article.comment"/>(${article.commentsCount})</a>
        </p>
            <%--<sec:authorize ifAnyGranted="ROLE_ADMIN">--%>
            <%--<form method="post" action="/article/delete?id=${article.id}">--%>
            <%--<input type="hidden" name="${_csrf.parameterName}"--%>
            <%--value="${_csrf.token}"/>--%>
            <%--<input type="submit" class="btn btn-lg btn-success" value="Delete article"/>--%>
            <%--</form>--%>
            <%--</sec:authorize>--%>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <form method="post" action="/article/delete?id=${article.id}">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <spring:message var="deleteButtonValue" code="article.delete"/>
                <input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>
            </form>
        </sec:authorize>
    </div>
</c:forEach>

