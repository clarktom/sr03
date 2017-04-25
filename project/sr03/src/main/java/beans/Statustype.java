package beans;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
public class Statustype {
    private int statusId;
    private String status;
    private Collection<Step> stepsByStatusId;

    @Id
    @Column(name = "statusID")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statustype that = (Statustype) o;

        if (statusId != that.statusId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "statustypeByStatusId")
    public Collection<Step> getStepsByStatusId() {
        return stepsByStatusId;
    }

    public void setStepsByStatusId(Collection<Step> stepsByStatusId) {
        this.stepsByStatusId = stepsByStatusId;
    }
}
