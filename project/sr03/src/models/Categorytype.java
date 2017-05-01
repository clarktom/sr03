package models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name = "categorytype")
public class Categorytype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryID", nullable = false)
    private int categoryId;
    @Column(name = "category")
    private String category;
    @OneToMany(mappedBy = "categorytype", cascade = CascadeType.ALL)
    private Set<Idea> ideas;

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Idea> getIdeas() {
        return ideas;
    }
    public void setIdeas(Set<Idea> ideas) {
        this.ideas = ideas;
    }

}
