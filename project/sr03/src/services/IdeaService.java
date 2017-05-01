package services;

import models.Idea;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tompu on 30/04/2017.
 */
public class IdeaService {

    public void addIdea(Idea idea) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(idea);
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    public List<Idea> getAllIdeas() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select i from Idea i");
        List<Idea> ideas = query.list();
        session.getTransaction().commit();
        return ideas;
    }

    public Idea getIdea(Integer id, UriInfo uriInfo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Idea.class, id);
        if (obj == null) {
            throw new DataNotFoundException("Idea with id " + id + " not found");
        }
        return (Idea)obj;
    }

    public void deleteIdea(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Idea.class, id);
        if (obj == null) {
            throw new DataNotFoundException("Idea with id " + id + " not found");
        }
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void updateIdea(Idea idea) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(idea);
        session.getTransaction().commit();
    }


}
