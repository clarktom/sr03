package beans;

import javax.persistence.*;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
@Table(name="baseidea")
public class Baseidea {
    private int baseIdeaId;
    private int stepId;
//    private Step stepByStepId;

    @Id
    @GeneratedValue
    @Column(name = "baseIdeaID")
    public int getBaseIdeaId() {
        return baseIdeaId;
    }

    public void setBaseIdeaId(int baseIdeaId) {
        this.baseIdeaId = baseIdeaId;
    }

    @Basic
    @Column(name = "stepID")
    public int getStepId() {
        return stepId;
    }

    public void setStepId(int stepId) {
        this.stepId = stepId;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Baseidea baseidea = (Baseidea) o;
//
//        if (baseIdeaId != baseidea.baseIdeaId) return false;
//        if (stepId != baseidea.stepId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = baseIdeaId;
//        result = 31 * result + stepId;
//        return result;
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
