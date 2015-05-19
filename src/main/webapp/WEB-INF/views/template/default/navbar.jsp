<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
