package beans;

import jdk.internal.instrumentation.TypeMapping;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
@Table(name="idea")
public class Idea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ideaID")
    private int ideaId;

    @Column(name = "title")
    private String title;

    @Column(name = "categoryID")
    private int categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "creationDate")
    private Timestamp creationDate;

    @Column(name = "researcherID")
    private int researcherId;

    @Transient
    private List<Link> links = new ArrayList<Link>();
//    private Researcher researcherByIdeaId;
//    private Categorytype categorytypeByCategoryId;
//    private Collection<Step> stepsByIdeaId;


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


    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }


    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    @Transient
    public List<Link> getLinks() {
        return links;
    }
    @Transient
    public void setLinks(List<Link> links) {
        this.links = links;
    }
    @Transient
    public void addLink(String url, String rel) {
        Link link = new Link();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Idea idea = (Idea) o;
//
//        if (ideaId != idea.ideaId) return false;
//        if (categoryId != idea.categoryId) return false;
//        if (researcherId != idea.researcherId) return false;
//        if (title != null ? !title.equals(idea.title) : idea.title != null) return false;
//        if (description != null ? !description.equals(idea.description) : idea.description != null) return false;
//        if (creationDate != null ? !creationDate.equals(idea.creationDate) : idea.creationDate != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = ideaId;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + categoryId;
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
//        result = 31 * result + researcherId;
//        return result;
//    }
//
//    @OneToOne
//    @JoinColumn(name = "ideaID", referencedColumnName = "researcherID", nullable = false,insertable = false, updatable =false)
//    public Researcher getResearcherByIdeaId() {
//        return researcherByIdeaId;
//    }
//
//    public void setResearcherByIdeaId(Researcher researcherByIdeaId) {
//        this.researcherByIdeaId = researcherByIdeaId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "categoryID", referencedColumnName = "categoryID", nullable = false,insertable = false, updatable =false)
//    public Categorytype getCategorytypeByCategoryId() {
//        return categorytypeByCategoryId;
//    }
//
//    public void setCategorytypeByCategoryId(Categorytype categorytypeByCategoryId) {
//        this.categorytypeByCategoryId = categorytypeByCategoryId;
//    }
//
//    @OneToMany(mappedBy = "ideaByIdeaId")
//    public Collection<Step> getStepsByIdeaId() {
//        return stepsByIdeaId;
//    }
//
//    public void setStepsByIdeaId(Collection<Step> stepsByIdeaId) {
//        this.stepsByIdeaId = stepsByIdeaId;
//    }
}
