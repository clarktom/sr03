
function loadSteps(idIdea)
{
    var div = document.getElementById("steps");
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/", function (reponse) {

        var steps = JSON.parse(reponse);
        steps.forEach(function (step) {

            var titreElt = document.createElement("h2");
            titreElt.textContent = step.title;

            var contenuElt = document.createElement("p");
            contenuElt.textContent = step.description;

            div.appendChild(titreElt);
            div.appendChild(contenuElt);
        })
    });
}