package services;

import beans.Step;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.ArrayList;

/**
 * Created by tompu on 30/04/2017.
 */
public class StepService {

    private SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private Session session = factory.openSession();

    public ArrayList<Step> getAllSteps() {
        Query query = session.createQuery( "from Step S");
        return (ArrayList<Step>)query.list();
    }

    public Step getStep(Integer id) {
        Query query = session.createQuery( "from Step S where S.stepId = :id");
        query.setParameter("id", id);
        Step step = (Step)query.uniqueResult();
        if (step == null) {
            throw new DataNotFoundException("Step with id " + id + " not found");
        }
        return step;
    }

//    public Step addStep(Step step) throws Exception {
////        SessionFactory factory = new Configuration().configure().buildSessionFactory();
////        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(idea);
//            session.flush();
//            tx.commit();
//        } catch (Exception e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            throw e;
//        }
//        Integer id = (Integer) session.createQuery("SELECT max( i.ideaId ) FROM Idea i").uniqueResult();
//        Query query = session.createQuery("from Idea I where I.ideaId = :id");
//        query.setParameter("id", id);
//        idea = (Step) query.uniqueResult();
//        session.close();
//        factory.close();
//
//        return idea;
//    }

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

//    public Step removeIdea(Integer id) throws Exception {
//        Step idea = getIdea(id);
//        Query query = session.createQuery("delete Idea I where I.ideaId = :id");
//        query.setParameter("id", id);
//        if (query.executeUpdate() <= 0) {
//            throw new Exception("impossible de supprimer la data");
//        }
//        return idea;
//    }

}
