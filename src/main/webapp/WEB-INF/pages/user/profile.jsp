<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 27.01.2015
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<jsp:include page="../head.jsp"/>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <br>
    <div class="row">
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
        <jsp:include page="../sidebar.jsp"/>
    </div>
</div>
<jsp:include page="../footer.jsp"/>
</body>
</html>
