package models;

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

    public Step getStep() {
        return step;
    }
    public void setStep(Step step) {
        this.step = step;
    }

}
