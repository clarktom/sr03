<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<c:choose>
    <%-- Vérification de la présence d'un objet utilisateur en session --%>
    <c:when test="${!empty sessionScope.sessionUtilisateur}">
        <p> Vous êtes déjà connecté. </p>
    </c:when>
    <c:otherwise>
        <form method="post" action="<c:url value="/connexion" />">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="username">Nom d'utilisateur <span class="requis">*</span></label>
                <input type="username" id="username" name="username" value="<c:out value="${utilisateur.username}"/>" size="20" maxlength="60" />
                <br/>

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <br/>

                <input type="submit" value="Connexion" class="sansLabel" />
                <br/>

                <p class="erreur">${form.erreurs['username']}</p>
                <p class="erreur">${form.erreurs['motdepasse']}</p>
                <p class="erreur">${form.erreurs['all']}</p>
                <%//<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>%>

            </fieldset>
        </form>
    </c:otherwise>
</c:choose>