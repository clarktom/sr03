<%@ page import="models.Researcher" %><%--
  Created by IntelliJ IDEA.
  User: AUGUSTIN
  Date: 30/05/2017
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<jsp:include page="WEB-INF/head.jsp" />
<body onload="loadUserInfo('${param.username}')">

<jsp:include page="WEB-INF/header.jsp" />
<div id="userInfo"></div>
<div id="articles"></div>
</body>

</html>