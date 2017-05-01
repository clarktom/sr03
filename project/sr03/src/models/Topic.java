package models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topicID", nullable = false)
    private int topicId;
    @Column(name = "locked")
    private Byte locked;
    @Column(name = "creationDate")
    private Timestamp creationDate;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<Post> posts;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;


    public int getTopicId() {
        return topicId;
    }
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public Byte getLocked() {
        return locked;
    }
    public void setLocked(Byte locked) {
        this.locked = locked;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Step getStep() {
        return step;
    }
    public void setStep(Step step) {
        this.step = step;
    }

}
