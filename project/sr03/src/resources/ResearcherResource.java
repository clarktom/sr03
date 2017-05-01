package resources;

import models.Researcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.Transaction;
import services.ResearcherService;

import javax.persistence.PersistenceException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/researchers")
public class ResearcherResource {

    ResearcherService researcherService = new ResearcherService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Researcher> getResearchers() {
        return researcherService.getAllResearchers();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Researcher getResearcher(@PathParam("username") String username) {
        return researcherService.getResearcher(username);
    }

    /*
        AJOUT D'UN CHERCHEUR
        Prends en paramètre un JSON (exp: {"name": "JP","surname": "JL","username": "LP2","email": "ave@ave.ave","password": "admin"})
        Envoyé par POST.
        Renvoie true ou false selon le succès de l'opération d'ajout.
        //A tester avec un logiciel d'envoie de requête POST
    */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Researcher addResearcher(Researcher researcher) throws Exception {
        return researcherService.addResearcher(researcher);
    }

}
