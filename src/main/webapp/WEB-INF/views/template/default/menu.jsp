<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav" id="top">
            <a class="blog-nav-item active" href="/article/"><spring:message code="menu.home"/></a>
            <%--<a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New features</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">Press</a>--%>
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="blog-nav-item" href="<c:url value="/login"/>"> <spring:message code="menu.login"/></a>
                <a class="blog-nav-item" href="/user/register/"><spring:message code="menu.register"/> </a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="blog-nav-item" href="/article/form"><spring:message code="menu.addArticle"/></a>
                <c:url value="/logout" var="logoutUrl"/>
                <a class="blog-nav-item" href="${logoutUrl}"><spring:message code="menu.logout"/> </a>
                <%-- <form action="/logout">
                     <input type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}"/>
                     <input type="submit" value="Log out"/>
                 </form>--%>
            </c:if>
            <%--<form action="/login?logout">
                &lt;%&ndash;<input type="hidden" name="${_csrf.parameterName}"&ndash;%&gt;
                       &lt;%&ndash;value="${_csrf.token}"/>&ndash;%&gt;
                <input class="btn btn-lg btn-success btn-block" type="submit" value="Logout">
            </form>--%>
            <%--<a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">About</a>--%>
            <a class="blog-nav-item" href="/?mylocale=en">English </a> |
            <a class="blog-nav-item" href="/?mylocale=ru">Русский </a>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a class="blog-nav-item" href="/admin">Admin's page</a>
            </sec:authorize>
        </nav>
    </div>
</div>