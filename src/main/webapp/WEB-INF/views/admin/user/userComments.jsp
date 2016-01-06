<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:forEach var="comment" items="${comments}">
    <div class="panel panel-default">
        <div class="panel-heading">
            <c:set var="username" scope="request" value="${comment.user.name}"/>
            <strong><a href="/admin/user/${username}/">${username}</a></strong>
                                <span class="text-muted"><spring:message code="comment.at"/>
                                    <fmt:parseDate value="${comment.publicationDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
                                                   var="parsedDate" type="both"/>
                                    <fmt:formatDate type="both"
                                                    pattern="HH:mm:ss dd/MM/yyyy"
                                                    value="${parsedDate}"/>
                                    <%--${comment.publicationDate}--%>
                                </span>
        </div>
        <div class="panel-body">
            <p>
                    ${comment.text}
            </p>
        </div>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <div class="panel-footer">
                <form name="deleteCommentForm"
                      action="/comments/delete?commentId=${comment.id}&articleId=${article.id}"
                      method="post">
                    <spring:message var="deleteButtonValue" code="comment.delete"/>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>
                </form>
            </div>
        </sec:authorize>
    </div>
</c:forEach>
<p><a href="/admin/user/${userName}">Go back</a></p>