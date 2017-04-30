package beans;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
@Table(name="post")
public class Post {
    private int postId;
    private String text;
    private Timestamp date;
    private int researcherId;
    private int topicId;
//    private Researcher researcherByResearcherId;
//    private Topic topicByTopicId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postID")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "researcherID")
    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    @Basic
    @Column(name = "topicID")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Post post = (Post) o;
//
//        if (postId != post.postId) return false;
//        if (researcherId != post.researcherId) return false;
//        if (topicId != post.topicId) return false;
//        if (text != null ? !text.equals(post.text) : post.text != null) return false;
//        if (date != null ? !date.equals(post.date) : post.date != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = postId;
//        result = 31 * result + (text != null ? text.hashCode() : 0);
//        result = 31 * result + (date != null ? date.hashCode() : 0);
//        result = 31 * result + researcherId;
//        result = 31 * result + topicId;
//        return result;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "researcherID", referencedColumnName = "researcherID", nullable = false,insertable = false, updatable =false)
//    public Researcher getResearcherByResearcherId() {
//        return researcherByResearcherId;
//    }
//
//    public void setResearcherByResearcherId(Researcher researcherByResearcherId) {
//        this.researcherByResearcherId = researcherByResearcherId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "topicID", referencedColumnName = "topicID", nullable = false,insertable = false, updatable =false)
//    public Topic getTopicByTopicId() {
//        return topicByTopicId;
//    }
//
//    public void setTopicByTopicId(Topic topicByTopicId) {
//        this.topicByTopicId = topicByTopicId;
//    }
}
