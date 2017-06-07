<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <jsp:include page="WEB-INF/head.jsp" />
    </head>

    <body onload="loadPosts(${param.ideaID}, ${param.topicID})">
        <jsp:include page="WEB-INF/header.jsp" />
        <textarea id="send_post_textarea" name="textarea" rows="5" >

        </textarea>
        <button id="send_post_button" onclick="SendMsg()"> Envoyer le post</button>
        <div id="posts"></div>
    </body>
</html>

