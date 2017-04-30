package resources;

import beans.Idea;
import services.IdeaService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/ideas")
public class IdeaResource {

    IdeaService ideaService = new IdeaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Idea> getResearchers() {
        return ideaService.getAllIdeas();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Idea getIdea(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Idea idea = ideaService.getIdea(id);
//        idea.addLink(getUriForSelf(id, uriInfo), "self");
//        idea.addLink(getUriForStep(id, uriInfo), "self");
        return idea;
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
//                    .path(IdeaResource.class)
//                    .path(Integer.toString(id))
//                    .build()
//                    .toString();
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Idea addIdea(Idea idea) throws Exception {
        return ideaService.addIdea(idea);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Idea removeIdea(@PathParam("id") Integer id) throws Exception {
        return ideaService.removeIdea(id);
    }

}
