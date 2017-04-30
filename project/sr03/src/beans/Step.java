package beans;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
public class Step {
    private int stepId;
    private Date creationDate;
    private String title;
    private String description;
    private double progression;
//    private String progressionText;
    private int ideaId;
    private int statusId;
//    private Collection<Baseidea> baseideasByStepId;
//    private Collection<Product> productsByStepId;
//    private Collection<Prototype> prototypesByStepId;
//    private Collection<Simulation> simulationsByStepId;
//    private Idea ideaByIdeaId;
//    private Statustype statustypeByStatusId;
//    private Collection<Topic> topicsByStepId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stepID")
    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }

    @Basic
    @Column(name = "creationDate")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "progression")
    public double getProgression() {
        return progression;
    }

    public void setProgression(double progression) {
        this.progression = progression;
    }

//    @Basic
//    @Column(name = "progressionText")
//    public String getProgressionText() {
//        return progressionText;
//    }
//
//    public void setProgressionText(String progressionText) {
//        this.progressionText = progressionText;
//    }

    @Basic
    @Column(name = "ideaID")
    public int getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(int ideaId) {
        this.ideaId = ideaId;
    }

    @Basic
    @Column(name = "statusID")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Step step = (Step) o;
//
//        if (stepId != step.stepId) return false;
//        if (Double.compare(step.progression, progression) != 0) return false;
//        if (ideaId != step.ideaId) return false;
//        if (statusId != step.statusId) return false;
//        if (creationDate != null ? !creationDate.equals(step.creationDate) : step.creationDate != null) return false;
//        if (title != null ? !title.equals(step.title) : step.title != null) return false;
//        if (description != null ? !description.equals(step.description) : step.description != null) return false;
////        if (progressionText != null ? !progressionText.equals(step.progressionText) : step.progressionText != null)
////            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = stepId;
//        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        temp = Double.doubleToLongBits(progression);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
////        result = 31 * result + (progressionText != null ? progressionText.hashCode() : 0);
//        result = 31 * result + ideaId;
//        result = 31 * result + statusId;
//        return result;
//    }
//
//    @OneToMany(mappedBy = "stepByStepId")
//    public Collection<Baseidea> getBaseideasByStepId() {
//        return baseideasByStepId;
//    }
//
//    public void setBaseideasByStepId(Collection<Baseidea> baseideasByStepId) {
//        this.baseideasByStepId = baseideasByStepId;
//    }
//
//    @OneToMany(mappedBy = "stepByStepId")
//    public Collection<Product> getProductsByStepId() {
//        return productsByStepId;
//    }
//
//    public void setProductsByStepId(Collection<Product> productsByStepId) {
//        this.productsByStepId = productsByStepId;
//    }
//
//    @OneToMany(mappedBy = "stepByStepId")
//    public Collection<Prototype> getPrototypesByStepId() {
//        return prototypesByStepId;
//    }
//
//    public void setPrototypesByStepId(Collection<Prototype> prototypesByStepId) {
//        this.prototypesByStepId = prototypesByStepId;
//    }
//
//    @OneToMany(mappedBy = "stepByStepId")
//    public Collection<Simulation> getSimulationsByStepId() {
//        return simulationsByStepId;
//    }
//
//    public void setSimulationsByStepId(Collection<Simulation> simulationsByStepId) {
//        this.simulationsByStepId = simulationsByStepId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "ideaID", referencedColumnName = "ideaID", nullable = false,insertable = false, updatable =false)
//    public Idea getIdeaByIdeaId() {
//        return ideaByIdeaId;
//    }
//
//    public void setIdeaByIdeaId(Idea ideaByIdeaId) {
//        this.ideaByIdeaId = ideaByIdeaId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "statusID", referencedColumnName = "statusID", nullable = false,insertable = false, updatable =false)
//    public Statustype getStatustypeByStatusId() {
//        return statustypeByStatusId;
//    }
//
//    public void setStatustypeByStatusId(Statustype statustypeByStatusId) {
//        this.statustypeByStatusId = statustypeByStatusId;
//    }
//
//    @OneToMany(mappedBy = "stepByStepId")
//    public Collection<Topic> getTopicsByStepId() {
//        return topicsByStepId;
//    }
//
//    public void setTopicsByStepId(Collection<Topic> topicsByStepId) {
//        this.topicsByStepId = topicsByStepId;
//    }
}
