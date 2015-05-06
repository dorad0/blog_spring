<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav" id="top">
            <a class="blog-nav-item active" href="/article/">Home</a>
            <%--<a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New features</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">Press</a>--%>

            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <a class="blog-nav-item" href="<c:url value="/login" />"> Login</a>
                <a class="blog-nav-item" href="/user/register/">Register</a>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="blog-nav-item" href="/article/form">Add article</a>
                <c:url value="/logout" var="logoutUrl" />
                <a class="blog-nav-item" href="${logoutUrl}">Log Out</a>
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
        </nav>
    </div>
</div>