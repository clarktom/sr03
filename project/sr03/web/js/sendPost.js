


function sendPost(idIdea, idTopic)
{
    var txt_area = document.getElementById("send_post_textarea");
    var post_txt = txt_area.value;

    var params = "text='" + post_txt + "'&" + "topicId=" + idTopic  + "&" + "ideaId=" + idIdea;
    console.log(params);
    ajaxPost("http://localhost:8080/sr03/sendPost", params, function (reponse) {
        loadPosts(idIdea, idTopic);
    });
}

