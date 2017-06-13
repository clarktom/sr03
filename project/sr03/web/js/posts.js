/**
 * Created by tompu on 30/05/2017.
 */


function loadPosts(idIdea, idTopic)
{
    var div = document.getElementById("posts");
    div.innerHTML = "<div class='loading_background'><img width='30px' src='rsc/loading.svg'/></div>";
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/topics/" + idTopic + "/posts", function (reponse) {
        var posts = JSON.parse(reponse);
        div.innerHTML = "";
        posts.reverse();
        posts.forEach(function (post) {

            var div_post= document.createElement("div");
            div_post.className = "listElt";

            var titreElt = document.createElement("h2");

            var userLink = document.createElement("a");
            userLink.href = "user.jsp?username=" + post.links[2].rel;
            userLink.textContent =post.links[2].rel;


            titreElt.innerHTML = "Par " + userLink.outerHTML + " le " + new Date(post.date);

            var contenuElt = document.createElement("p");
            contenuElt.textContent = post.text;

            div_post.appendChild(titreElt);
            div_post.appendChild(contenuElt);

            div.appendChild(div_post);
        })
    });
}

