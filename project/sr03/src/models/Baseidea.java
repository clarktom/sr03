package models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "baseidea")
public class Baseidea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baseIdeaID", nullable = false)
    private int baseIdeaId;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;


    public int getBaseIdeaId() {
        return baseIdeaId;
    }
    public void setBaseIdeaId(int baseIdeaId) {
        this.baseIdeaId = baseIdeaId;
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
