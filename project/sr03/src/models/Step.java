package models;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "step")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stepID", nullable = false)
    private int stepId;
    @Column(name = "creationDate")
    private Date creationDate;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "progression")
    private double progression;
    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private Set<Baseidea> baseideas;
    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private Set<Product> products;
    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private Set<Prototype> prototypes;
    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL)
    private Set<Simulation> simulations;
    @ManyToOne //TODO: @ManyToMany
    @JoinColumn(name = "ideaID")
    private Idea idea;
    @ManyToOne
    @JoinColumn(name = "statusID")
    private Statustype statustype;
//    @OneToMany(mappedBy = "step", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Topic> topics;
    @OneToOne(mappedBy = "step", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

    public Step() {

    }

    public Step(Date creationDate, String title, String description, double progression) {
        this.creationDate = creationDate;
        this.title = title;
        this.description = description;
        this.progression = progression;
    }

    public int getStepId() {
        return stepId;
    }
    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getProgression() {
        return progression;
    }
    public void setProgression(double progression) {
        this.progression = progression;
    }

    @JsonIgnore
    public Set<Baseidea> getBaseideas() {
        return baseideas;
    }
    public void setBaseideas(Set<Baseidea> baseideas) {
        this.baseideas = baseideas;
    }

    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @JsonIgnore
    public Set<Prototype> getPrototypes() {
        return prototypes;
    }
    public void setPrototypes(Set<Prototype> prototypes) {
        this.prototypes = prototypes;
    }

    @JsonIgnore
    public Set<Simulation> getSimulations() {
        return simulations;
    }
    public void setSimulations(Set<Simulation> simulations) {
        this.simulations = simulations;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="ideaId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("ideaId")
    public Idea getIdea() {
        return idea;
    }
    public void setIdea(Idea idea) {
        this.idea = idea;
    }

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="statusId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("statusId")
    public Statustype getStatustype() {
        return statustype;
    }
    public void setStatustype(Statustype statustype) {
        this.statustype = statustype;
    }

//    @JsonIgnore
//    public Set<Topic> getTopics() {
//        return topics;
//    }
//    public void setTopics(Set<Topic> topics) {
//        this.topics = topics;
//    }

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
