<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav>
  <ul class="pager">
    <c:if test="${page.previous}">
      <li><a href="/admin/article/archive/${year}/${month}/page/${page.previousPage}/"><spring:message code="nav.prev"/></a>
      </li>
    </c:if>
    <c:if test="${page.next}">
      <li><a href="/admin/article/archive/${year}/${month}/page/${page.nextPage}/"><spring:message code="nav.next"/></a>
      </li>
    </c:if>
  </ul>
</nav>