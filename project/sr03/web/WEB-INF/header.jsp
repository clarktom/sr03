<%--
  Created by IntelliJ IDEA.
  User: AUGUSTIN
  Date: 16/05/2017
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <c:choose>
        <c:when test="${!empty sessionScope.sessionUtilisateur}">
            <div>
                <span id="pseudo_header">${sessionScope.sessionUtilisateur.name}</span>
            </div>

        </c:when>
    </c:choose>
    <div>
        <h1>Cherchorum</h1>
    </div>
</header>