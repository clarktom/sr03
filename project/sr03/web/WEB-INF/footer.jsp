<%--
  Created by IntelliJ IDEA.
  User: AUGUSTIN
  Date: 11/06/2017
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<footer onload="loadFooter('${sessionScope.sessionUtilisateur.getUsername()}')">
    <div id="currentUser" >
    </div>
</footer>
