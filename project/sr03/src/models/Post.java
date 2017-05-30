package models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postID", nullable = false)
    private int postId;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private Timestamp date;
    @ManyToOne
    @JoinColumn(name = "researcherID")
    private Researcher researcher;
    @ManyToOne
    @JoinColumn(name = "topicID")
    private Topic topic;

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

    public Post() {

    }

    public Post(String text, Timestamp date, Researcher researcher, Topic topic) {
        this.text = text;
        this.date = date;
        this.researcher = researcher;
        this.topic = topic;
    }

    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getDate() {
        return date;
    }
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="researcherId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("researcherId")
    public Researcher getResearcher() {
        return researcher;
    }
    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="topicId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("topicId")
    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
