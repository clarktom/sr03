package models;

import javax.persistence.*;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "prototype")
public class Prototype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prototypeID", nullable = false)
    private int prototypeId;
    @Column(name = "market")
    private String market;
    @Column(name = "resources")
    private String resources;
    @Column(name = "results")
    private String results;
    @ManyToOne
    @JoinColumn(name = "stepID")
    private Step step;

    public int getPrototypeId() {
        return prototypeId;
    }
    public void setPrototypeId(int prototypeId) {
        this.prototypeId = prototypeId;
    }

    public String getMarket() {
        return market;
    }
    public void setMarket(String market) {
        this.market = market;
    }

    public String getResources() {
        return resources;
    }
    public void setResources(String resources) {
        this.resources = resources;
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
