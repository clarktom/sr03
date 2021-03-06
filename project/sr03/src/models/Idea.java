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
@Table(name = "idea")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideaID", nullable = false)
    private int ideaId;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "creationDate")
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "researcherID")
    private Researcher researcher;
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Categorytype categorytype;
    @OneToMany(mappedBy = "idea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Step> steps;

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

    public Idea() {

    }

    public Idea(String title, String description, Date creationDate, Researcher researcher, Categorytype categorytype) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.researcher = researcher;
        this.categorytype = categorytype;
    }


    public int getIdeaId() {
        return ideaId;
    }
    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
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

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="categoryId")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("categoryId")
    public Categorytype getCategorytype() {
        return categorytype;
    }
    public void setCategorytype(Categorytype categorytype) {
        this.categorytype = categorytype;
    }

    @JsonIgnore
    public Set<Step> getSteps() {
        return steps;
    }
    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }

}
