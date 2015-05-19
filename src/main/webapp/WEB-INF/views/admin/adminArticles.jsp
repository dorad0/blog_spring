<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-8 blog-main">
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
              href="/user/${article.user.name}/">${article.user.name}</a>
      </p>

      <p>
          ${article.text}
      </p>

      <p>
        <a href="/comments/${article.id}/"><spring:message
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
        <form method="post" action="/article/${article.id}">
          <input type="hidden" name="${_csrf.parameterName}"
                 value="${_csrf.token}"/>
          <spring:message var="deleteButtonValue" code="article.delete"/>
          <input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>
        </form>
      </sec:authorize>
    </div>
  </c:forEach>
  <nav>
    <ul class="pager">
      <c:if test="${page.previous}">
        <li><a href="/article/page/${page.previousPage}/"><spring:message code="nav.prev"/></a></li>
      </c:if>
      <c:if test="${page.next}">
        <li><a href="/article/page/${page.nextPage}/"><spring:message code="nav.next"/></a></li>
      </c:if>
    </ul>
  </nav>
</div>
