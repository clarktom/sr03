package api;

import beans.Researcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/researchers")
public class ResearcherResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Researcher> getResearcherList() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery( "from Researcher R");
        ArrayList<Researcher> researcherList = (ArrayList<Researcher>)query.list();
        return researcherList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Researcher getResearcher(@PathParam("username") String username) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Query query = session.createQuery( "from Researcher R where R.username = :username");
        query.setParameter("username", username);
        Researcher researcher = (Researcher)query.list().get(0);
        return researcher;
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
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addResearcher(Researcher rs)
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(rs);
        try
        {
            session.getTransaction().commit();
        }
        catch(PersistenceException E)
        {
            return false;
        }
        return true;
    }

}
