/**
 * Created by AUGUSTIN on 30/05/2017.
 */
function loadUserInfo(username) {
    //var userInfoElt = document.getElementById("userInfo");
    var URL="http://localhost:8080/sr03/api/researchers/" + username;
    ajaxGet(URL, function (reponse) {
        var userInfoElt = document.getElementById("userInfo");

        var UserItemsList =  document.createElement("ul");

        userInfoElt.appendChild(UserItemsList);
        var userInfo = JSON.parse(reponse);

        console.log(userInfo.username);
        var titreElt = document.createElement("p");

        //create and add the name div with id="name"
        var liName = document.createElement("li");
        var nameText = document.createElement("span");
        nameText.textContent = "Nom : " + userInfo.name;
        liName.appendChild(nameText)
        UserItemsList.appendChild(liName);

        //create the surname div with id="surname"
        var liSurname = document.createElement("li");
        var surnameText = document.createElement("span");
        surnameText.textContent = "Prénom : " + userInfo.surname;
        liSurname.appendChild(surnameText);
        UserItemsList.appendChild(liSurname);

        //create the username div with id="username"
        var liUsername = document.createElement("li");
        var UsernameText = document.createElement("span");
        UsernameText.textContent = "Nom d'utilisateur : " + userInfo.username;
        liUsername.appendChild(UsernameText)
        UserItemsList.appendChild(liUsername);

        var liMail = document.createElement("li");
        var emailText = document.createElement("span");
        emailText.textContent = "Email : " + userInfo.email;
        liMail.appendChild(emailText)
        UserItemsList.appendChild(liMail);


    });
}



