package beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by utilisateur on 17/04/2017.
 */
@Entity
public class Researcher implements Serializable {

    private int researcherId;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Idea ideaByResearcherId;
    private Collection<Post> postsByResearcherId;

    public Researcher() {
    }

    public Researcher(String name, String surname, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "researcherID")
    public int getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Researcher that = (Researcher) o;

        if (researcherId != that.researcherId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = researcherId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToOne(mappedBy = "researcherByIdeaId")
    public Idea getIdeaByResearcherId() {
        return ideaByResearcherId;
    }

    public void setIdeaByResearcherId(Idea ideaByResearcherId) {
        this.ideaByResearcherId = ideaByResearcherId;
    }

    @OneToMany(mappedBy = "researcherByResearcherId")
    public Collection<Post> getPostsByResearcherId() {
        return postsByResearcherId;
    }

    public void setPostsByResearcherId(Collection<Post> postsByResearcherId) {
        this.postsByResearcherId = postsByResearcherId;
    }
}
