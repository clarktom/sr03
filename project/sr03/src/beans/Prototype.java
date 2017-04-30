package beans;

import javax.persistence.*;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
@Table(name="prototype")
public class Prototype {
    private int prototypeId;
    private String market;
    private String resources;
    private String results;
    private int stepId;
//    private Step stepByStepId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prototypeID")
    public int getPrototypeId() {
        return prototypeId;
    }

    public void setPrototypeId(int prototypeId) {
        this.prototypeId = prototypeId;
    }

    @Basic
    @Column(name = "market")
    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    @Basic
    @Column(name = "resources")
    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    @Basic
    @Column(name = "results")
    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
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
//        Prototype prototype = (Prototype) o;
//
//        if (prototypeId != prototype.prototypeId) return false;
//        if (stepId != prototype.stepId) return false;
//        if (market != null ? !market.equals(prototype.market) : prototype.market != null) return false;
//        if (resources != null ? !resources.equals(prototype.resources) : prototype.resources != null) return false;
//        if (results != null ? !results.equals(prototype.results) : prototype.results != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = prototypeId;
//        result = 31 * result + (market != null ? market.hashCode() : 0);
//        result = 31 * result + (resources != null ? resources.hashCode() : 0);
//        result = 31 * result + (results != null ? results.hashCode() : 0);
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
