<%@ page import="models.Researcher" %>
<%@ page import="services.IdeaService" %>
<%@ page import="java.awt.*" %>
<%@ page import="models.Idea" %>
<%@ page import="java.util.ArrayList" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<c:choose>
    <c:when test="${!empty sessionScope.sessionUtilisateur}">

<%
    /*Researcher ut = (Researcher)session.getAttribute("sessionUtilisateur");
    out.println( ut.getEmail());*/

    IdeaService idr = new IdeaService();
    ArrayList<Idea> ideas = (ArrayList<Idea>)idr.getAllIdeas();

    for (Idea idea : ideas)
    {
        out.println(idea.getIdeaId() + " : "  + idea.getTitle() + " par " + idea.getResearcher().getName());
        out.println("<br/>");
    }
%>


    </c:when>
</c:choose>