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

public class StepResource {

    StepService stepService = new StepService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Step> getAllSteps(@PathParam("ideaId") Integer ideaId, @Context UriInfo uriInfo) {
        List<Step> steps = stepService.getAllSteps(ideaId);
//        for (Step step : steps) {
//            step.addLink(getUriForSelf(uriInfo, step), "self");
//            step.addLink(getUriForPosts(uriInfo, step), "posts");
//        }
        return steps;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{stepId}")
    public Step getStep(@PathParam("ideaId") Integer ideaId,
                         @PathParam("stepId") Integer stepId,
                         @Context UriInfo uriInfo) {
        Step step = stepService.getStep(ideaId, stepId, uriInfo);
        step.addLink(getUriForSelf(uriInfo, step), "self");
        step.addLink(getUriForTopic(uriInfo, step), "topic");
        return step;
    }

    private String getUriForTopic(UriInfo uriInfo, Step step) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getTopicResource")
                .resolveTemplate("ideaId", step.getIdea().getIdeaId())
                .path(Integer.toString(step.getTopic().getTopicId()))
                .build()
                .toString();
    }

    private String getUriForSelf(UriInfo uriInfo, Step step) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getStepResource")
                .path(Integer.toString(step.getStepId()))
                .resolveTemplate("ideaId", step.getIdea().getIdeaId())
                .build()
                .toString();
    }

}
