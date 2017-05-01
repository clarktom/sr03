package models;

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

    public Step getStep() {
        return step;
    }
    public void setStep(Step step) {
        this.step = step;
    }
}
