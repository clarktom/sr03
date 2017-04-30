package services;

import beans.Idea;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;

/**
 * Created by tompu on 30/04/2017.
 */
public class IdeaService {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Session session = factory.openSession();

    public ArrayList<Idea> getAllIdeas() {
        Query query = session.createQuery( "from Idea I");
        return (ArrayList<Idea>)query.list();
    }

    public Idea getIdea(Integer id) {
        Query query = session.createQuery( "from Idea I where I.ideaId = :id");
        query.setParameter("id", id);
        Idea idea = (Idea)query.uniqueResult();
        if (idea == null) {
            throw new DataNotFoundException("Idea with id " + id + " not found");
        }
        return idea;
    }

    public Idea addIdea(Idea idea) throws Exception {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(idea);
            session.flush();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        Integer id = (Integer) session.createQuery("SELECT max( i.ideaId ) FROM Idea i").uniqueResult();
        Query query = session.createQuery("from Idea I where I.ideaId = :id");
        query.setParameter("id", id);
        idea = (Idea) query.uniqueResult();
        session.close();
        factory.close();

        return idea;
    }

//    public Idea updateIdea(Integer id) throws Exception {
//        String hqlUpdate = "update Idea I set " +
//                "I.categoryId = :newCategoryId " +
//                "I.creationDate = :newCreationDate " +
//                "I.description = :newDescription " +
//                "I.researcherId = :newResearcherId " +
//                "I.title= :newTitle " +
//                "where I.ideaId = :id";
//        int updatedEntities = session.createQuery( hqlUpdate )
//                .setString( "newCategoryId", newCategoryId )
//                .setString( "oldName", oldName )
//                .executeUpdate();
//        tx.commit();
//        session.close();
//    }

    public Idea removeIdea(Integer id) throws Exception {
        Idea idea = getIdea(id);
        Query query = session.createQuery("delete Idea I where I.ideaId = :id");
        query.setParameter("id", id);
        if (query.executeUpdate() <= 0) {
            throw new Exception("impossible de supprimer la data");
        }
        return idea;
    }

}
