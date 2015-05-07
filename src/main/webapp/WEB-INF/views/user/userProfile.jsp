<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="col-sm-8 blog-main">
    <p>
        User name: <c:out value="${user.name}"/>
    </p>

    <p>
        <fmt:setLocale scope="session" value="en_US"/>
        <fmt:parseDate value="${user.registrationDate}" pattern="yyyy-MM-dd'T'HH:mm:ss"
                       var="parsedDate" type="both" />
        <fmt:formatDate var="userRegistrationDate" type="both"
                        pattern="HH:mm:ss dd/MM/yyyy"
                        value="${parsedDate}"/>
        Register: ${userRegistrationDate}
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
