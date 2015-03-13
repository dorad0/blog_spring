<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 26.02.2015
  Time: 14:52
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
                User <c:out value="${user.name}"/> (articles and comments) was deleted successfully.
            </p>
       <%--     <p>
                Register: <fmt:formatDate value="${user.registrationDate.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </p>--%>
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
