<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-sm-8 blog-main">
    <div class="blog-post">
        <h2 class="blog-post-title">
            ${article.title}
        </h2>
        <p class="blog-post-meta">
            <fmt:setLocale scope="session" value="en_US"/>
            <fmt:parseDate value="${article.publicationDate}" pattern="yyyy-MM-dd"
                           var="parsedDate" type="both" />
            <fmt:formatDate value="${parsedDate}"
                            type="both" pattern="MMMMM d, yyyy" />
            by <a
                href="/user/${article.user.name}/"> <c:out
                value="${article.user.name}"/> </a>
        </p>
        <p>${article.text}</p>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
            <form:form name="deleteArticleForm" action="/article/delete?id=${article.id}">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <input type="submit" class="btn btn-lg btn-success" value="Delete article"/>
            </form:form>
        </sec:authorize>
        <div class="col-lg-12">
            <c:forEach var="comment" items="${comments}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <c:set var="username" scope="request" value="${comment.user.name}"/>
                        <strong><a href="/user/${username}/">${username}</a></strong>
                                <span class="text-muted">at
                                    <fmt:setLocale scope="session" value="en_US"/>
                               <%-- <fmt:formatDate type="both"
                                                dateStyle="short" timeStyle="short"
                                                value="${comment.publicationDate.time}"/>--%><%--5 days ago--%>
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
                                  action="/comments/delete?commentId=${comment.id}&articleId=${article.id}"
                                  method="post">
                                <input type="hidden" name="${_csrf.parameterName}"
                                       value="${_csrf.token}"/>
                                <input type="submit" class="btn btn-lg btn-success" value="Delete comment"/>
                            </form>
                        </div>
                    </sec:authorize>
                </div>
            </c:forEach>
            <div id="end"></div>
            <sec:authorize access="isAuthenticated()">
                <form:form name="addCommentForm" action="/comments/add/${article.id}" cssClass="form-inline"
                           modelAttribute="commentForm">
                    <div class="form-group">
                        <input type="text" class="form-control" name="text" placeholder="Your comment"/>
                        <form:errors path="text" cssClass="has-error"/>
                        <sec:authentication var="userName" property="principal.username"/>
                        <input name="userName" value="${userName}" type="hidden"/>
                        <input name="articleId" value="${article.id}" type="hidden"/>
                        <button type="submit" class="btn btn-default">Add</button>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form:form>
            </sec:authorize>
        </div>
    </div>
</div>
