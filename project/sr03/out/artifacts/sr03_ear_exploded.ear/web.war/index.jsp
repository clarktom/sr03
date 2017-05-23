<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <jsp:include page="WEB-INF/head.jsp" />
  <body>
  <jsp:include page="WEB-INF/header.jsp" />

    <article>

      <c:choose>
          <c:when test="${empty sessionScope.sessionUtilisateur}">
              <jsp:include page="WEB-INF/unconnected.jsp" />
          </c:when>
          <c:otherwise>
              <html

          </c:otherwise>
      </c:choose>
    </article>
  </body>
</html>
