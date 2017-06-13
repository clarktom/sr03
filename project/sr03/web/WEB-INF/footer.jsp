<%--
  Created by IntelliJ IDEA.
  User: AUGUSTIN
  Date: 11/06/2017
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer>

    <c:if test="${not empty sessionScope.sessionUtilisateur}">
            <div id="currentUser" >
                <span>Utilisateur connecté : <a href="user.jsp?username=${sessionScope.sessionUtilisateur.getUsername()}" >${sessionScope.sessionUtilisateur.getUsername()}</a> </span>
            </div>
    </c:if>


</footer>



