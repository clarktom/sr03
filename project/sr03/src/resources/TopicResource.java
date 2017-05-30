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
    public List<Topic> getAllTopics(@PathParam("ideaId") Integer ideaId, @Context UriInfo uriInfo) {
        List<Topic> topics = topicService.getAllTopics(ideaId);
        for (Topic topic : topics) {
            topic.addLink(getUriForSelf(uriInfo, topic), "self");
            topic.addLink(getUriForPosts(uriInfo, topic), "posts");
        }
        return topics;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{topicId}")
    public Topic getStep(@PathParam("ideaId") Integer ideaId,
                         @PathParam("topicId") Integer topicId,
                         @Context UriInfo uriInfo) {
        Topic topic = topicService.getTopic(ideaId, topicId, uriInfo);
        topic.addLink(getUriForSelf(uriInfo, topic), "self");
        topic.addLink(getUriForPosts(uriInfo, topic), "posts");
        return topic;
    }

    private String getUriForPosts(UriInfo uriInfo, Topic topic) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getTopicResource")
                .resolveTemplate("ideaId", topic.getStep().getIdea().getIdeaId())
                .path(TopicResource.class, "getPostResource")
                .resolveTemplate("topicId", topic.getTopicId())
                .build()
                .toString();
    }

    private String getUriForSelf(UriInfo uriInfo, Topic topic) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getTopicResource")
                .path(Integer.toString(topic.getTopicId()))
                .resolveTemplate("ideaId", topic.getStep().getIdea().getIdeaId())
                .build()
                .toString();
    }

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
