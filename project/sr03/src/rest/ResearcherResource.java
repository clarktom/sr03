package rest;

import beans.Researcher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Created by tompu on 25/04/2017.
 */

@Path("/researcher")
public class ResearcherResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{username}")
    public Researcher getResearcher(@PathParam("username") String username) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "from Researcher R where R.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        System.out.print("Test");
        Researcher researcher = (Researcher)query.list().get(0);
        return researcher;
    }


}
