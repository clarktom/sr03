/**
 * Created by AUGUSTIN on 30/05/2017.
 */
function loadUserInfo(username) {
    //var userInfoElt = document.getElementById("userInfo");
    var URL="http://localhost:8080/sr03/api/researchers/" + username;
    ajaxGet(URL, function (reponse) {
        var userInfoElt = document.getElementById("userInfo");

        var userInfo = JSON.parse(reponse);

        console.log(userInfo.username);
        var titreElt = document.createElement("p");

        //create and add the name div with id="name"
        var divName = document.createElement("div");
        divName.id = "name"
        var nameText = document.createElement("span");
        nameText.textContent = "Nom : " + userInfo.name;
        divName.appendChild(nameText)
        userInfoElt.appendChild(divName);

        //create the surname div with id="surname"
        var divSurname = document.createElement("div");
        divSurname.id = "surname"
        var surnameText = document.createElement("span");
        surnameText.textContent = "Prénom : " + userInfo.surname;
        divSurname.appendChild(surnameText)
        userInfoElt.appendChild(divSurname);

        //create the username div with id="username"
        var divUsername = document.createElement("div");
        divUsername.id = "username"
        var UsernameText = document.createElement("span");
        UsernameText.textContent = "Nom d'utilisateur : " + userInfo.username;
        divUsername.appendChild(UsernameText)
        userInfoElt.appendChild(divUsername);

        var divemail = document.createElement("div");
        divemail.id = "email"
        var emailText = document.createElement("span");
        emailText.textContent = "Email : " + userInfo.email;
        divemail.appendChild(emailText)
        userInfoElt.appendChild(divemail);


    });
}



