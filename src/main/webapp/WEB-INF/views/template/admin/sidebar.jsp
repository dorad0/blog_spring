<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="sticky" class="col-sm-3 col-sm-offset-1 blog-sidebar">
  <div class="sidebar-module sidebar-module-inset">
    <h4><spring:message code="sidebar.about"/></h4>

    <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet
      fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
  </div>
  <div class="sidebar-module">
    <h4><spring:message code="sidebar.archives"/></h4>
    <ol class="list-unstyled">
      <c:forEach var="date" items="${dates}">
        <li>
          <a href="/admin/article/archive/${date.getYear()}/${date.getMonthValue()}/">
              <%--<fmt:setLocale scope="session" value="en_US"/>--%>
            <fmt:parseDate value="${date}" pattern="yyyy-MM-dd"
                           var="parsedDate" type="both"/>
            <fmt:formatDate value="${parsedDate}"
                            type="both" pattern="MMMMM yyyy"/>
          </a>
        </li>
      </c:forEach>
    </ol>
  </div>
  <div class="sidebar-module">
    <h4><spring:message code="sidebar.elsewhere"/></h4>
    <ol class="list-unstyled">
      <li><a href="http://getbootstrap.com/examples/blog/#">GitHub</a></li>
      <li><a href="http://getbootstrap.com/examples/blog/#">Twitter</a></li>
      <li><a href="http://getbootstrap.com/examples/blog/#">Facebook</a></li>
    </ol>
  </div>
</div>
