package services;

import models.Topic;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 30/04/2017.
 */
public class TopicService {

    public void addTopic(Topic topic) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(topic);
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        session.getTransaction().commit();
    }

    public List<Topic> getAllTopics(Integer ideaId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select t from Topic t where t.step.stepId in (select s.stepId from Step s where s.idea.ideaId = :ideaId)");
        query.setParameter("ideaId", ideaId);
        List<Topic> topics = query.list();
        session.getTransaction().commit();
        if (topics.size() == 0) {
            throw new DataNotFoundException("Topics for Idea with id " + ideaId + " not found");
        }
        return topics;
    }

    public Topic getTopic(Integer ideaId, Integer topicId, UriInfo uriInfo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query= session.createQuery("select t from Topic t where t.step.stepId in (select s.stepId from Step s where s.idea.ideaId = :ideaId) and t.topicId = :topicId");
        query.setParameter("ideaId", ideaId);
        query.setParameter("topicId", topicId);
        Object obj = query.uniqueResult();
        if (obj == null) {
            throw new DataNotFoundException("Topic with id " + topicId + " not found in Idea id " + ideaId);
        }
        return (Topic)obj;
    }

    public void deleteTopic(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Topic.class, id);
        if (obj == null) {
            throw new DataNotFoundException("Topic with id " + id + " not found");
        }
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void updateTopic(Topic topic) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(topic);
        session.getTransaction().commit();
    }

}
