package services;

import models.Post;
import exceptions.DataNotFoundException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by tompu on 30/04/2017.
 */
public class PostService {

    public void addPost(Post post) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {

            session.close();
        }
    }

    public List<Post> getAllPosts(Integer topicId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("select p from Post p where p.topic.topicId = :topicId");
        query.setParameter("topicId", topicId);
        List<Post> posts = query.list();
        session.getTransaction().commit();

        return posts;
    }

    public Post getPost(Integer topicId, Integer postId, UriInfo uriInfo) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query= session.createQuery("select p from Post p where p.topic.topicId = :topicId and p.postId = :postId");
        query.setParameter("topicId", topicId);
        query.setParameter("postId", postId);
        Object obj = query.uniqueResult();
        if (obj == null) {
            throw new DataNotFoundException("Post with postId " + postId + " related to Topic with topicId " + topicId + " not found");
        }
        return (Post)obj;
    }

    public void deletePost(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(Post.class, id);
        if (obj == null) {
            throw new DataNotFoundException("Post with id " + id + " not found");
        }
        session.delete(obj);
        session.getTransaction().commit();
    }

    public void updatePost(Post post) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.update(post);
        session.getTransaction().commit();
    }

}
