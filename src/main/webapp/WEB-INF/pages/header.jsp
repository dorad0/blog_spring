<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="http://getbootstrap.com/examples/blog/#">Home</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New features</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">Press</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New hires</a>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="blog-nav-item" href="<c:url value="/login?logout" />"> Logout</a>
            </c:if>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">About</a>
        </nav>
    </div>
</div>