package services;

import beans.Researcher;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 * Created by tompu on 29/04/2017.
 */
public class ResearcherService {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Session session = factory.openSession();

    public ArrayList<Researcher> getAllResearchers() {
        Query query = session.createQuery( "from Researcher R");
        return (ArrayList<Researcher>)query.list();
    }

    public Researcher getResearcher(String username) {
        Query query = session.createQuery( "from Researcher R where R.username = :username");
        query.setParameter("username", username);
        Researcher researcher = (Researcher)query.uniqueResult();
        if (researcher == null) {
            throw new DataNotFoundException("Researcher with username " + username + " not found");
        }
        return researcher;
    }

    public boolean addResearcher(Researcher rs) {
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
