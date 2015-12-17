<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<div class="col-sm-8 blog-main">--%>
<div class="blog-post">
    <h2 class="blog-post-title">
        ${article.title}
    </h2>
    <p class="blog-post-meta">
        <fmt:parseDate value="${article.publicationDate}" pattern="yyyy-MM-dd"
                       var="parsedDate" type="both" />
        <fmt:formatDate value="${parsedDate}"
                        type="both" pattern="MMMMM d, yyyy" />
        <spring:message code="article.by"/> <a
            href="/admin/user/${article.user.name}/"> <c:out
            value="${article.user.name}"/> </a>
    </p>
    <p>${article.text}</p>
    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <form:form name="deleteArticleForm" action="/admin/article/delete?id=${article.id}">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <spring:message var="deleteButtonValue" code="article.delete"/>
            <input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>
        </form:form>
    </sec:authorize>
    <div class="col-lg-12">
        <c:forEach var="comment" items="${comments}">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <c:set var="username" scope="request" value="${comment.user.name}"/>
                    <strong><a href="/admin/user/${username}/">${username}</a></strong>
                                <span class="text-muted"><spring:message code="comment.at"/>
                                    <fmt:parseDate value="${comment.publicationDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
                                                   var="parsedDate" type="both" />
                                    <fmt:formatDate type="both"
                                                    pattern="HH:mm:ss dd/MM/yyyy"
                                                    value="${parsedDate}"/>
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
                              action="/admin/comments/delete?commentId=${comment.id}&articleId=${article.id}"
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
        <div id="end"></div>
        <sec:authorize access="isAuthenticated()">
            <form:form name="addCommentForm" action="/admin/comments/add/${article.id}" cssClass="form-inline"
                       modelAttribute="commentForm">
                <div class="form-group">
                    <spring:message var="commentFormText" code="comment.form"/>
                    <input type="text" class="form-control" name="text" placeholder="${commentFormText}"/>
                    <form:errors path="text" cssClass="has-error"/>
                    <sec:authentication var="userName" property="principal.username"/>
                    <input name="userName" value="${userName}" type="hidden"/>
                    <input name="articleId" value="${article.id}" type="hidden"/>
                    <button type="submit" class="btn btn-default"><spring:message code="comment.add"/></button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form:form>
        </sec:authorize>
    </div>
</div>
<%--</div>--%>
