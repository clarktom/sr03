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

    <body onload="loadSteps(${param.ideaID})">
        <jsp:include page="WEB-INF/header.jsp" />
        <div id="steps"></div>
    </body>
</html>

