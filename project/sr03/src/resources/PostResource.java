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
    public List<Post> getAllPosts(@PathParam("topicId") Integer topicId) {
        return postService.getAllPosts(topicId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{postId}")
    public Post getPost(@PathParam("topicId") Integer topicId,
                        @PathParam("postId") Integer postId,
                        @Context UriInfo uriInfo) {
        Post post = postService.getPost(topicId, postId, uriInfo);
//        post.addLink(getUriForSelf(id, uriInfo), "self");
//        post.addLink(getUriForStep(id, uriInfo), "self");
        return post;
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
