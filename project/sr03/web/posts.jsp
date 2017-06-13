<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${empty sessionScope.sessionUtilisateur}">
        <c:redirect url="/index.jsp"/>
    </c:when>
</c:choose>

<html>
    <head>
        <jsp:include page="WEB-INF/head.jsp" />
    </head>

    <body onload="loadPosts(${param.ideaID}, ${param.topicID})">
        <jsp:include page="WEB-INF/header.jsp" />

        <div id="send_post_div">
            <textarea id="send_post_textarea" name="textarea" rows="5" ></textarea>
            <br/>
            <button id="send_post_button" onclick="sendPost(${param.ideaID}, ${param.topicID})"> Envoyer le post</button>
        </div>
        <div id="posts"></div>
        <jsp:include page="WEB-INF/footer.jsp" />
    </body>
</html>

