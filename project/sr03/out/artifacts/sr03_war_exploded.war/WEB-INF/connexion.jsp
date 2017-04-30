<%--
  Created by IntelliJ IDEA.
  User: tompu
  Date: 29/04/2017
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Connexion</title>
    <link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<%--<form method="post" action="connexion">--%>
<form method="post" action="<c:url value="/connexion" />">
    <fieldset>
        <legend>Connexion</legend>
        <p>Vous pouvez vous connecter via ce formulaire.</p>

        <label for="nom">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />


        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />


        <input type="submit" value="Connexion" class="sansLabel" />


        <p class="erreur">${form.erreurs['all']}</p>
        <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>


    </fieldset>
</form>
</body>
</html>
