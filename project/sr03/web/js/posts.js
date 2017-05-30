/**
 * Created by tompu on 30/05/2017.
 */


function loadPosts(idIdea, idTopic)
{
    var div = document.getElementById("steps");
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/topics/" + idTopic, function (reponse) {
        var posts = JSON.parse(reponse);
        console.log(steps);
        posts.forEach(function (post) {

            var titreElt = document.createElement("h2");
            titreElt.textContent = post.postId;

            var contenuElt = document.createElement("p");
            contenuElt.textContent = post.text;

            div.appendChild(titreElt);
            div.appendChild(contenuElt);
        })
    });
}

