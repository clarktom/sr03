package beans;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
public class Categorytype {
    private int categoryId;
    private String category;
    private Collection<Idea> ideasByCategoryId;

    @Id
    @Column(name = "categoryID")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorytype that = (Categorytype) o;

        if (categoryId != that.categoryId) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categorytypeByCategoryId")
    public Collection<Idea> getIdeasByCategoryId() {
        return ideasByCategoryId;
    }

    public void setIdeasByCategoryId(Collection<Idea> ideasByCategoryId) {
        this.ideasByCategoryId = ideasByCategoryId;
    }
}
