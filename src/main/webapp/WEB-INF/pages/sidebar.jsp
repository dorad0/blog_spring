<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 23.02.2015
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<div id="sticky" class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div class="sidebar-module sidebar-module-inset">
        <h4>About</h4>

        <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet
            fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
    </div>
    <div class="sidebar-module">
        <h4>Archives</h4>
        <ol class="list-unstyled">
            <c:forEach var="date" items="${dates}">
                <li>
                    <a href="/article/archive/${date.time.year}/${date.time.month}" >
                        <fmt:formatDate value="${date.time}"
                                        pattern="MMMMM yyyy"/>
                    </a>
                </li>
            </c:forEach>
        </ol>
    </div>
    <div class="sidebar-module">
        <h4>Elsewhere</h4>
        <ol class="list-unstyled">
            <li><a href="http://getbootstrap.com/examples/blog/#">GitHub</a></li>
            <li><a href="http://getbootstrap.com/examples/blog/#">Twitter</a></li>
            <li><a href="http://getbootstrap.com/examples/blog/#">Facebook</a></li>
        </ol>
    </div>
</div>
<!-- /.blog-sidebar -->