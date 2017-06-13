<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:choose>
    <c:when test="${empty sessionScope.sessionUtilisateur}">
        <c:redirect url="/index.jsp"/>
    </c:when>
</c:choose>



<html lang="en">

    <jsp:include page="WEB-INF/head.jsp" />

    <body onload="loadIdeas()">
        <jsp:include page="WEB-INF/header.jsp" />
        <div id="articles"></div>
        <jsp:include page="WEB-INF/footer.jsp" />
    </body>


</html>