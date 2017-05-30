/**
 * Created by tompu on 30/05/2017.
 */


function loadPosts(idIdea, idTopic)
{
    var div = document.getElementById("posts");
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/topics/" + idTopic + "/posts", function (reponse) {
        console.log("http://localhost:8080/sr03/api/ideas/" + idIdea + "/topics/" + idTopic + "/posts");
        var posts = JSON.parse(reponse);
        console.log(posts);
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

