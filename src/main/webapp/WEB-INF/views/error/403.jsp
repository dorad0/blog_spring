<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-sm-8 blog-main">
    <c:choose>
        <c:when test="${empty username}">
            <h2>You do not have permission to access this page!</h2>
        </c:when>
        <c:otherwise>
            <h2>Username : ${username} <br/>You do not have permission to access this page!</h2>
        </c:otherwise>
    </c:choose>
</div>
