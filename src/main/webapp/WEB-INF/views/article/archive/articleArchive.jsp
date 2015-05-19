<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:forEach var="article" items="${page.entities}">
    <div class="blog-post">
        <h2 class="blog-post-title">
            <a href="/comments/${article.id}/">${article.title}</a>
        </h2>

        <p class="blog-post-meta">
                <%--<fmt:setLocale scope="session" value="en_US"/>--%>
            <fmt:parseDate value="${article.publicationDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
                           var="parsedDate" type="both"/>
            <fmt:formatDate type="both"
                            pattern="MMMMM d, yyyy"
                            value="${parsedDate}"/>
            <spring:message code="article.by"/> <a
                href="/user/<c:out value="${article.user.name}"/> "> <c:out
                value="${article.user.name}"/> </a>
        </p>

        <p>
                ${article.text}
        </p>

        <p>
            <a href="/comments/${article.id}/"><spring:message code="article.comment"/>(${article.commentsCount})</a>
        </p>
        <%--<sec:authorize ifAnyGranted="ROLE_ADMIN">--%>
            <%--<form method="post" action="/article/${article.id}">--%>
                <%--<input type="hidden" name="${_csrf.parameterName}"--%>
                       <%--value="${_csrf.token}"/>--%>
                <%--<spring:message var="deleteButtonValue" code="article.delete"/>--%>
                <%--<input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>--%>
            <%--</form>--%>
        <%--</sec:authorize>--%>
    </div>
</c:forEach>


