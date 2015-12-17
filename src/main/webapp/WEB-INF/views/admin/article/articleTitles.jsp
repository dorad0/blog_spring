<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-8 blog-main">
  <p>
    <a href="/admin/article/">Go back</a>
  </p>
  <c:forEach var="article" items="${articles}">
    <p>Title: <a href="/admin/comments/${article.id}/">${article.title}</a></p>

    <p>Author: <a href="/admin/user/${article.user.name}/">${article.user.name}</a></p>
    <sec:authorize ifAnyGranted="ROLE_ADMIN">
      <form method="post" action="/admin/article/delete?id=${article.id}">
        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <spring:message var="deleteButtonValue" code="article.delete"/>
        <input type="submit" class="btn btn-lg btn-success" value="${deleteButtonValue}"/>
      </form>
    </sec:authorize>
  </c:forEach>
  <p>
    <a href="/admin/article/">Go back</a>
  </p>
</div>

