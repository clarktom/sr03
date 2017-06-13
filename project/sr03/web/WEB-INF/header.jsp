<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<header>
    <h1> <a href="index.jsp"> Cherchorum </a> </h1>

    <c:choose>
        <c:when test="${not empty sessionScope.sessionUtilisateur}">
            <a href="index.jsp"> Idées > </a>
            <c:choose>
                <c:when test="${not empty param.ideaID}">
                <a href="steps.jsp?ideaID=${param.ideaID}"> Etapes > </a>

                    <c:choose>
                        <c:when test="${not empty param.topicID}">
                            <a href="posts.jsp?ideaID=${param.ideaID}&topicID=${param.topicID}"> Posts </a>
                        </c:when>
                    </c:choose>

                </c:when>
            </c:choose>


        </c:when>
    </c:choose>
</header>