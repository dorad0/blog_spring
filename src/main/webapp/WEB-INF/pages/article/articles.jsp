<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 22.01.2015
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="../head.jsp"/>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="blog-header">
        <h1 class="blog-title">The Blog</h1>

        <p class="lead blog-description">The official blog.</p>
    </div>
    <div class="row">
        <div class="col-sm-8 blog-main">
            <c:forEach var="article" items="${page.entities}">
                <div class="blog-post">
                    <h2 class="blog-post-title">
                        <a href="/comments/${article.id}">${article.title}</a>
                    </h2>

                    <p class="blog-post-meta">
                        <fmt:setLocale scope="session" value="en_US"/>
                        <fmt:formatDate value="${article.publicationDate.time}"
                                        pattern="MMMMM d, yyyy"/>
                        by <a
                            href="/user/<c:out value="${article.user.name}"/> "> <c:out
                            value="${article.user.name}"/> </a>
                    </p>

                    <p>
                            ${article.text}
                    </p>

                    <p>
                        <a href="/comments/${article.id}">Read comments(${article.commentsCount})</a>
                    </p>
                    <sec:authorize ifAnyGranted="ROLE_ADMIN">
                        <form method="post" action="/article/delete?id=${article.id}">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-lg btn-success" value="Delete"/>
                        </form>
                    </sec:authorize>
                </div>
                <!-- /.blog-post -->
            </c:forEach>
            <nav>
                <ul class="pager">
                    <c:if test="${page.previous}">
                        <li><a href="/article/page/${page.previousPage}">Previous</a></li>
                    </c:if>
                    <c:if test="${page.next}">
                        <li><a href="/article/page/${page.nextPage}">Next</a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
        <!-- /.blog-main -->
        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
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
                            <a href="http://getbootstrap.com/examples/blog/#">
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
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<jsp:include page="../footer.jsp"/>
<%--<footer class="blog-footer">--%>
<%--<p>Blog template built for <a href="http://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.--%>
<%--</p>--%>

<%--<p>--%>
<%--<a href="http://getbootstrap.com/examples/blog/#">Back to top</a>--%>
<%--</p>--%>
<%--</footer>--%>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/resources/js/ie10-viewport-bug-workaround.js"></script>


<%--<div id="global-zeroclipboard-html-bridge" class="global-zeroclipboard-container"--%>
<%--style="position: absolute; left: 0px; top: -9999px; width: 15px; height: 15px; z-index: 999999999;" title=""--%>
<%--data-original-title="Copy to clipboard">--%>
<%--<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id="global-zeroclipboard-flash-bridge" width="100%"--%>
<%--height="100%">--%>
<%--<param name="movie" value="/assets/flash/ZeroClipboard.swf?noCache=1422865088865">--%>
<%--<param name="allowScriptAccess" value="sameDomain">--%>
<%--<param name="scale" value="exactfit">--%>
<%--<param name="loop" value="false">--%>
<%--<param name="menu" value="false">--%>
<%--<param name="quality" value="best">--%>
<%--<param name="bgcolor" value="#ffffff">--%>
<%--<param name="wmode" value="transparent">--%>
<%--<param name="flashvars"--%>
<%--value="trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com">--%>
<%--<embed src="/assets/flash/ZeroClipboard.swf?noCache=1422865088865" loop="false" menu="false" quality="best"--%>
<%--bgcolor="#ffffff" width="100%" height="100%" name="global-zeroclipboard-flash-bridge"--%>
<%--allowscriptaccess="sameDomain" allowfullscreen="false" type="application/x-shockwave-flash"--%>
<%--wmode="transparent" pluginspage="http://www.macromedia.com/go/getflashplayer"--%>
<%--flashvars="trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com"--%>
<%--scale="exactfit">--%>
<%--</object>--%>
<%--</div>--%>
</body>
</html>