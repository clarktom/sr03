package models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "statustype")
public class Statustype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusID", nullable = false)
    private int statusId;
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "statustype", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Step> steps;


    public int getStatusId() {
        return statusId;
    }
    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonIgnore
    public Set<Step> getSteps() {
        return steps;
    }
    public void setSteps(Set<Step> steps) {
        this.steps = steps;
    }
}
