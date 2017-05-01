package resources;

import models.Topic;
import services.TopicService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/topics")
public class TopicResource {

    TopicService topicService = new TopicService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Topic> getTopics() {
        return topicService.getAllTopics();
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Step getStep(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
//        Step step = stepService.getStep(id);
//        step.addLink(getUriForSelf(id, uriInfo), "self");
//        step.addLink(getUriForStep(id, uriInfo), "self");
//        return step;
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

}
