<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <jsp:include page="WEB-INF/head.jsp" />
    </head>

    <body onload="loadPosts(${param.ideaID}, ${param.topicID})">
        <jsp:include page="WEB-INF/header.jsp" />
        <div id="posts"></div>
    </body>
</html>

