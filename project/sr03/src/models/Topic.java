package models;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Post> posts;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;

    @Transient
    private List<Link> links = new ArrayList<Link>();
    public List<Link> getLinks() {
        return links;
    }
    public void setLinks(List<Link> links) {
        this.links = links;
    }
    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }


    public Topic() {

    }

    public Topic(Byte locked, Timestamp creationDate, Step step) {
        this.locked = locked;
        this.creationDate = creationDate;
        this.step = step;
    }

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

    @JsonIgnore
    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="stepId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("stepId")
    public Step getStep() {
        return step;
    }
    public void setStep(Step step) {
        this.step = step;
    }

}
