package models;


import javax.persistence.*;
import java.sql.Timestamp;

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

    public Researcher getResearcher() {
        return researcher;
    }
    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
