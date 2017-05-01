package resources;

import models.Idea;
import models.Researcher;
import services.IdeaService;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/ideas")
public class IdeaResource {

    IdeaService ideaService = new IdeaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Idea> getAllIdeas(@Context UriInfo uriInfo) {
        List<Idea> ideas = ideaService.getAllIdeas();
        for (Idea idea : ideas) {
            idea.addLink(getUriForSelf(uriInfo, idea), "self");
            idea.addLink(getUriForResearcher(uriInfo, idea), "researcher");
//        idea.addLink(getUriForCategory(uriInfo, idea), "category");
            idea.addLink(getUriForTopics(uriInfo, idea), "topics");
        }
        return ideas;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Idea getIdea(@PathParam("id") Integer id, @Context UriInfo uriInfo) {
        Idea idea = ideaService.getIdea(id, uriInfo);
        idea.addLink(getUriForSelf(uriInfo, idea), "self");
        idea.addLink(getUriForResearcher(uriInfo, idea), "researcher");
//        idea.addLink(getUriForCategory(uriInfo, idea), "category");
        idea.addLink(getUriForTopics(uriInfo, idea), "topics");
        return idea;
    }

    private String getUriForTopics(UriInfo uriInfo, Idea idea) {
        return uriInfo.getBaseUriBuilder()
                .path(IdeaResource.class)
                .path(IdeaResource.class, "getTopicResource")
                .resolveTemplate("ideaId", idea.getIdeaId())
                .build()
                .toString();
    }

//    private String getUriForCategory(UriInfo uriInfo, Idea idea) {
//        return uriInfo.getBaseUriBuilder()
//                .path(CategoryResource.class)
//                .path(idea.getCategorytype().getCategory())
//                .build()
//                .toString();
//    }

    private String getUriForResearcher(UriInfo uriInfo, Idea idea) {
        return uriInfo.getBaseUriBuilder()
                .path(ResearcherResource.class)
                .path(idea.getResearcher().getUsername())
                .build()
                .toString();
    }

    private String getUriForSelf(UriInfo uriInfo, Idea idea) {
        return uriInfo.getBaseUriBuilder()
                    .path(IdeaResource.class)
                    .path(Integer.toString(idea.getIdeaId()))
                    .build()
                    .toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
    public void addIdea(Idea idea) throws Exception {
        ideaService.addIdea(idea);
    }

//    @DELETE
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/{id}")
//    public Idea removeIdea(@PathParam("id") Integer id) throws Exception {
//        return ideaService.removeIdea(id);
//    }

    @Path("/{ideaId}/topics")
    public TopicResource getTopicResource() {
        return new TopicResource();
    }

}
