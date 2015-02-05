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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <title>Blog Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="http://getbootstrap.com/examples/blog/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./Blog Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>
    <style type="text/css"></style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="http://getbootstrap.com/examples/blog/#">Home</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New features</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">Press</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">New hires</a>
            <a class="blog-nav-item" href="http://getbootstrap.com/examples/blog/#">About</a>
        </nav>
    </div>
</div>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">The Blog</h1>

        <p class="lead blog-description">The official blog.</p>
    </div>

    <div class="row">
        <div class="col-sm-8 blog-main">

            <c:forEach var="article" items="${page.articles}">
                <div class="blog-post">
                        <h2 class="blog-post-title">${article.title}</h2>
                    <p class="blog-post-meta">${article.date} by <a
                            href="<c:url value="/user/${article.author}"/>"><c:out value="${article.author}"/> </a>
                            <%--href="http://getbootstrap.com/examples/blog/#">${article.user.name}</a>--%>
                    </p>
                        ${article.text}
                </div>
                <!-- /.blog-post -->
            </c:forEach>


            <nav>
                <ul class="pager">
                    <li><a href="http://getbootstrap.com/examples/blog/#">Previous</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">Next</a></li>
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
                    <li><a href="http://getbootstrap.com/examples/blog/#">March 2014</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">February 2014</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">January 2014</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">December 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">November 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">October 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">September 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">August 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">July 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">June 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">May 2013</a></li>
                    <li><a href="http://getbootstrap.com/examples/blog/#">April 2013</a></li>
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

<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.
    </p>

    <p>
        <a href="http://getbootstrap.com/examples/blog/#">Back to top</a>
    </p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./Blog Template for Bootstrap_files/jquery.min.js"></script>
<script src="./Blog Template for Bootstrap_files/bootstrap.min.js"></script>
<script src="./Blog Template for Bootstrap_files/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./Blog Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


<div id="global-zeroclipboard-html-bridge" class="global-zeroclipboard-container"
     style="position: absolute; left: 0px; top: -9999px; width: 15px; height: 15px; z-index: 999999999;" title=""
     data-original-title="Copy to clipboard">
    <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id="global-zeroclipboard-flash-bridge" width="100%"
            height="100%">
        <param name="movie" value="/assets/flash/ZeroClipboard.swf?noCache=1422865088865">
        <param name="allowScriptAccess" value="sameDomain">
        <param name="scale" value="exactfit">
        <param name="loop" value="false">
        <param name="menu" value="false">
        <param name="quality" value="best">
        <param name="bgcolor" value="#ffffff">
        <param name="wmode" value="transparent">
        <param name="flashvars"
               value="trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com">
        <embed src="/assets/flash/ZeroClipboard.swf?noCache=1422865088865" loop="false" menu="false" quality="best"
               bgcolor="#ffffff" width="100%" height="100%" name="global-zeroclipboard-flash-bridge"
               allowscriptaccess="sameDomain" allowfullscreen="false" type="application/x-shockwave-flash"
               wmode="transparent" pluginspage="http://www.macromedia.com/go/getflashplayer"
               flashvars="trustedOrigins=getbootstrap.com%2C%2F%2Fgetbootstrap.com%2Chttp%3A%2F%2Fgetbootstrap.com"
               scale="exactfit">
    </object>
</div>
</body>
</html>