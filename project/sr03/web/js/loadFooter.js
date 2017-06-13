/**
 * Created by AUGUSTIN on 13/06/2017.
 */
function loadFooter(username) {
    //var userInfoElt = document.getElementById("userInfo");
    var URL="http://localhost:8080/sr03/api/researchers/" + username;
    ajaxGet(URL, function (reponse) {
        var userInfoElt = document.getElementById("currentUser");

        var CurrentlyConnected = document.createElement("div");
        var CurrentlyConnectedText = document.createElement("span");
        CurrentlyConnectedText.textContent = "Utilisateur actuellement connecté : ";
        CurrentlyConnected.appendChild(CurrentlyConnectedText);
        userInfoElt.appendChild(CurrentlyConnected);


        var userInfo = JSON.parse(reponse);

        console.log(userInfo.username);
        var titreElt = document.createElement("p");

        //create and add the name div with id="name"
        var divName = document.createElement("div");
        divName.id = "name";
        var nameText = document.createElement("span");
        nameText.textContent = "Nom : " + userInfo.name;
        divName.appendChild(nameText);
        userInfoElt.appendChild(divName);

        //create the surname div with id="surname"
        var divSurname = document.createElement("div");
        divSurname.id = "surname";
        var surnameText = document.createElement("span");
        surnameText.textContent = "Prénom : " + userInfo.surname;
        divSurname.appendChild(surnameText);
        userInfoElt.appendChild(divSurname);

        //create the username div with id="username"
        var divUsername = document.createElement("div");
        divUsername.id = "username";
        var UsernameText = document.createElement("span");
        UsernameText.textContent = "Nom d'utilisateur : " + userInfo.username;

        var link = document.createElement("a");
        link.href = "user.jsp?username=" + userInfo.username;

        divUsername.appendChild(UsernameText);
        link.appendChild(divUsername);
        userInfoElt.appendChild(link);

        var divemail = document.createElement("div");
        divemail.id = "email";
        var emailText = document.createElement("span");
        emailText.textContent = "Email : " + userInfo.email;
        divemail.appendChild(emailText);
        userInfoElt.appendChild(divemail);

        var link = document.createElement("a");
        link.href = "user.jsp?username=" + userInfo.username;



    });
}