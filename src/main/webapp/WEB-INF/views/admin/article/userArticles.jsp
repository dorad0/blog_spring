<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:forEach var="article" items="${articles}">
    <p><a href="/admin/comments/${article.id}">${article.title}</a></p>
</c:forEach>
<p><a href="/admin/user/${userName}">Go back</a></p>