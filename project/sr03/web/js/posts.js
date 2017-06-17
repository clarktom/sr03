/**
 * Created by tompu on 30/05/2017.
 */


function loadPosts(idIdea, idTopic)
{
    var div = document.getElementById("posts");
    div.innerHTML = div.innerHTML+"<div class='loading_background'><img width='30px' src='rsc/loading.svg'/></div>";
    ajaxGet("http://localhost:8080/sr03/api/ideas/" + idIdea + "/topics/" + idTopic + "/posts", function (reponse) {
        var posts = JSON.parse(reponse);
        div.innerHTML = "";
        posts.forEach(function (post) {

            var div_post= document.createElement("div");
            div_post.className = "post";


            var userLink = document.createElement("a");
            userLink.href = "user.jsp?username=" + post.links[2].rel;
            userLink.textContent =post.links[2].rel;

            div_post.innerHTML =
                "<div class = 'left_elt'> " +
                " <table style='text-align:center;'> <tr><td>" +
                "<img src='rsc/profle.png' width='50' height='50'></td>" +
                "  </tr><tr> <td> " +
                userLink.outerHTML +
                "   </td></tr></table> " +

                "</div>" +

                "<div class='right_elt'>" +
                "<div class='top_elt'>" +
                new Date(post.date) +
                "</div>" +
                post.text +
                "</div>" ;


            /*var titreElt = document.createElement("h2");
            titreElt.

            var userLink = document.createElement("a");
            userLink.href = "user.jsp?username=" + post.links[2].rel;
            userLink.textContent =post.links[2].rel;


            titreElt.innerHTML =  userLink.outerHTML + " <br/> " + new Date(post.date);

            var contenuElt = document.createElement("p");
            contenuElt.textContent = post.text;

            div_post.appendChild(titreElt);
            div_post.appendChild(contenuElt);*/

            div.appendChild(div_post);
        })
    });
}

