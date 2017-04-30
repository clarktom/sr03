<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<c:choose>
    <%-- Vérification de la présence d'un objet utilisateur en session --%>
    <c:when test="${!empty sessionScope.sessionUtilisateur}">
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
        <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur}</p>
    </c:when>
    <c:otherwise>
        <article>
            <a href="connexion">Formulaire de connexion</a>
        </article>
    </c:otherwise>
</c:choose>