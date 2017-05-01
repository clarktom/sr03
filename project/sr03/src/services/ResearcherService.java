package services;

import models.Researcher;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 30/04/2017.
 */
public class ResearcherService {

    public void addResearcher(Researcher researcher) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(researcher);
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    public List<Researcher> getAllResearchers() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select r from Researcher r");
        List<Researcher> researchers = query.list();
        session.getTransaction().commit();
        return researchers;
    }

    public Researcher getResearcher(String username, UriInfo uriInfo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Researcher.class, username);
        if (obj == null) {
            throw new DataNotFoundException("Researcher with username " + username + " not found");
        }
        return (Researcher)obj;
    }

    public void deleteResearcher(String username) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Researcher.class, username);
        if (obj == null) {
            throw new DataNotFoundException("Researcher with username " + username + " not found");
        }
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void updateResearcher(Researcher researcher) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(researcher);
        session.getTransaction().commit();
    }

}