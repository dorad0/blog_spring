<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-8 blog-main">
    <p>
        User name: <c:out value="${user.name}"/>
    </p>

    <p>
        Register: <fmt:formatDate value="${user.registrationDate.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
    </p>
    <sec:authorize ifAnyGranted="ROLE_ADMIN">
        <form name="deleteUserForm" action="/user/delete/${user.id}" method="post">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <input type="submit" class="btn btn-lg btn-success" value="Delete user"/>
        </form>
    </sec:authorize>
    <p>
        <a href="/article/">Go back</a>
    </p>
</div>
