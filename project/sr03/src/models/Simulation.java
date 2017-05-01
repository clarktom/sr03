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
@Table(name = "simulation")
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simulationID", nullable = false)
    private int simulationId;
    @Basic
    @Column(name = "results")
    private String results;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;


    public int getSimulationId() {
        return simulationId;
    }
    public void setSimulationId(int simulationId) {
        this.simulationId = simulationId;
    }


    public String getResults() {
        return results;
    }
    public void setResults(String results) {
        this.results = results;
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
