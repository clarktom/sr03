/**
 * Created by tompu on 23/05/2017.
 */

function loadIdeas() {
    var articlesElt = document.getElementById("articles");
    articlesElt.innerHTML = "<div class='loading_background'><img width='30px' src='rsc/loading.svg'/></div>";
    ajaxGet("http://localhost:8080/sr03/api/ideas", function (reponse) {
        // Transforme la réponse en tableau d'objets JavaScript
        var ideas = JSON.parse(reponse);
        articlesElt.innerHTML = "";
        // Affiche le titre de chaque film
        ideas.forEach(function (idea) {

            var div_idea = document.createElement("div");
            div_idea.className = "listElt";

            var titreElt = document.createElement("h2");
            titreElt.textContent = idea.title;

            var contenuElt = document.createElement("p");
            contenuElt.textContent = idea.description;



            div_idea.appendChild(titreElt);
            div_idea.appendChild(contenuElt);

            var link = document.createElement("a");
            link.href = "steps.jsp?ideaID=" + idea.ideaId


            link.appendChild(div_idea);
            articlesElt.appendChild(link)

        })
    });
}
