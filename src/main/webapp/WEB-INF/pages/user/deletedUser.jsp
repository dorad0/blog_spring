<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
