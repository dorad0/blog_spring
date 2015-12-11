<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="col-sm-8 blog-main">
    <c:forEach items="articles" var="article">
        <p><a href="/article/${article.title}">${article.title}</a> </p>
    </c:forEach>
</div>