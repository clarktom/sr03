package beans;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
@Table(name="topic")
public class Topic {
    private int topicId;
    private Byte locked;
    private Timestamp creationDate;
    private int stepId;
    private Collection<Post> postsByTopicId;
    private Step stepByStepId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicID")
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "locked")
    public Byte getLocked() {
        return locked;
    }

    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    @Basic
    @Column(name = "creationDate")
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "stepID")
    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Topic topic = (Topic) o;
//
//        if (topicId != topic.topicId) return false;
//        if (stepId != topic.stepId) return false;
//        if (locked != null ? !locked.equals(topic.locked) : topic.locked != null) return false;
//        if (creationDate != null ? !creationDate.equals(topic.creationDate) : topic.creationDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = topicId;
//        result = 31 * result + (locked != null ? locked.hashCode() : 0);
//        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
//        result = 31 * result + stepId;
//        return result;
//    }
//
//    @OneToMany(mappedBy = "topicByTopicId")
//    public Collection<Post> getPostsByTopicId() {
//        return postsByTopicId;
//    }
//
//    public void setPostsByTopicId(Collection<Post> postsByTopicId) {
//        this.postsByTopicId = postsByTopicId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "stepID", referencedColumnName = "stepID", nullable = false,insertable = false, updatable =false)
//    public Step getStepByStepId() {
//        return stepByStepId;
//    }
//
//    public void setStepByStepId(Step stepByStepId) {
//        this.stepByStepId = stepByStepId;
//    }
}
