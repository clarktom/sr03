package services;

import models.Step;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 30/04/2017.
 */
public class StepService {

    public void addStep(Step step) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(step);
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    public List<Step> getAllSteps(Integer ideaId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select s from Step s where s.stepId in (select s.stepId from Step s where s.idea.ideaId = :ideaId)");
        query.setParameter("ideaId", ideaId);
        List<Step> steps = query.list();
        session.getTransaction().commit();
        if (steps.size() == 0) {
            throw new DataNotFoundException("Steps for Idea with id " + ideaId + " not found");
        }
        return steps;
    }

    public Step getStep(Integer ideaId, Integer stepId, UriInfo uriInfo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query= session.createQuery("select s from Step s where s.stepId in (select s.stepId from Step s where s.idea.ideaId = :ideaId) and s.stepId = :stepId");
        query.setParameter("ideaId", ideaId);
        query.setParameter("stepId", stepId);
        Object obj = query.uniqueResult();
        if (obj == null) {
            throw new DataNotFoundException("Step with id " + stepId + " not found in Idea id " + ideaId);
        }
        return (Step)obj;
    }

    public void deleteStep(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Step.class, id);
        if (obj == null) {
            throw new DataNotFoundException("Step with id " + id + " not found");
        }
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void updateStep(Step step) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(step);
        session.getTransaction().commit();
    }

}
