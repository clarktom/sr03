package resources;

import models.Post;
import services.PostService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 25/04/2017.
 */

public class PostResource {

    PostService postService = new PostService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllPosts(@PathParam("topicId") Integer topicId, @Context UriInfo uriInfo) {
        List<Post> posts = postService.getAllPosts(topicId);
        for (Post post : posts) {
            post.addLink(getUriForSelf(uriInfo, post), "self");
            post.addLink(getUriForResearcher(uriInfo, post), "researcher");
            post.addLink("researcher_pseudo", post.getResearcher().getUsername());
        }
        return posts;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{postId}")
    public Post getPost(@PathParam("topicId") Integer topicId,
                        @PathParam("postId") Integer postId,
                        @Context UriInfo uriInfo) {
        Post post = postService.getPost(topicId, postId, uriInfo);
        post.addLink(getUriForSelf(uriInfo, post), "self");
        post.addLink(getUriForResearcher(uriInfo, post), "researcher");
        return post;
    }

    private String getUriForSelf(UriInfo uriInfo, Post post) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getTopicResource")
                .resolveTemplate("ideaId", post.getTopic().getStep().getIdea().getIdeaId())
                .path(TopicResource.class, "getPostResource")
                .resolveTemplate("topicId", post.getTopic().getTopicId())
                .path(Integer.toString(post.getPostId()))
                .build()
                .toString();
    }

    private String getUriForResearcher(UriInfo uriInfo, Post post) {
        return uriInfo.getBaseUriBuilder()
                .path(ResearcherResource.class)
                .path(post.getResearcher().getUsername())
                .build()
                .toString();
    }

//    private String getUriForStep(Integer id, UriInfo uriInfo) {
//        return uriInfo.getBaseUriBuilder()
//                .path(StepResource.class)
//                .path(Integer.toString(id))
//                .build()
//                .toString();
//    }
//
//    private String getUriForSelf(Integer id, UriInfo uriInfo) {
//        return uriInfo.getBaseUriBuilder()
//                    .path(PostResource.class)
//                    .path(Integer.toString(id))
//                    .build()
//                    .toString();
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public void addPost(Post post) throws Exception {
        postService.addPost(post);
    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Post removePost(@PathParam("id") Integer id) throws Exception {
//        return postService.removePost(id);
//    }

}
