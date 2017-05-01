package resources;

import models.Topic;
import services.TopicService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 25/04/2017.
 */

public class TopicResource {

    TopicService topicService = new TopicService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Topic> getAllTopics(@PathParam("ideaId") Integer ideaId) {
        return topicService.getAllTopics(ideaId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{topicId}")
    public Topic getStep(@PathParam("ideaId") Integer ideaId,
                         @PathParam("topicId") Integer topicId,
                         @Context UriInfo uriInfo) {
        Topic topic = topicService.getTopic(ideaId, topicId, uriInfo);
//        step.addLink(getUriForSelf(id, uriInfo), "self");
//        step.addLink(getUriForStep(id, uriInfo), "self");
        return topic;
    }

//    @GET
//    @Path("/{topicId}")
//    public String getString() {
//        return "Yep";
//    }

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
//                .path(IdeaResource.class)
//                .path(Integer.toString(id))
//                .build()
//                .toString();
//    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Idea addIdea(Idea idea) throws Exception {
//        return stepService.addStep(idea);
//    }
//
//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Idea removeIdea(@PathParam("id") Integer id) throws Exception {
//        return stepService.removeIdea(id);
//    }

    @Path("/{topicId}/posts")
    public PostResource getPostResource() {
        return new PostResource();
    }

}
