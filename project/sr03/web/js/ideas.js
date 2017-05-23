/**
 * Created by tompu on 23/05/2017.
 */

var articlesElt = document.getElementById("articles");
ajaxGet("http://localhost:8080/sr03/api/ideas", function (reponse) {
    // Transforme la réponse en tableau d'objets JavaScript
    var ideas = JSON.parse(reponse);
    // Affiche le titre de chaque film
    ideas.forEach(function (idea) {
        console.log(idea.title);
        // Ajout du titre et du contenu de chaque article
        var titreElt = document.createElement("h2");
        titreElt.textContent = idea.title;
        var contenuElt = document.createElement("p");
        contenuElt.textContent = idea.description;
        articlesElt.appendChild(titreElt);
        articlesElt.appendChild(contenuElt);
    })
});