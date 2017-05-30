
function loadSteps(idIdea)
{


    var div = document.getElementById("steps");
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/steps/", function (reponse) {
        var steps = JSON.parse(reponse);
        console.log(steps);
        steps.forEach(function (step) {

            var div_step = document.createElement("div");

            var titreElt = document.createElement("h2");
            titreElt.textContent = step.title;

            var contenuElt = document.createElement("p");
            contenuElt.textContent = step.description;



            div_step.appendChild(titreElt);
            div_step.appendChild(contenuElt);

            var link = document.createElement("a");
            link.href = "posts.jsp?ideaID=" + idIdea + "&topicID=" + step.topicId


            link.appendChild(div_step);
            div.appendChild(link)
        })
    });
}