<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-8 blog-main">
    <p>List of users</p>
    <c:forEach var="user" items="${users}">
        <p>
            <a href="/admin/user/${user.name}">${user.name}</a>
        </p>
    </c:forEach>
    <p>
        <a href="/admin/">Go back</a>
    </p>
</div>