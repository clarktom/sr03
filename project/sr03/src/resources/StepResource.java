package resources;

import models.Step;
import services.StepService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/steps")
public class StepResource {

    StepService stepService = new StepService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Step> getSteps() {
        return stepService.getAllSteps();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Step getStep(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Step step = stepService.getStep(id, uriInfo);
//        step.addLink(getUriForSelf(id, uriInfo), "self");
//        step.addLink(getUriForStep(id, uriInfo), "self");
        return step;
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
