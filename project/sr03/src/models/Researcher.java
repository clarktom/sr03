package models;


import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by tompu on 01/05/2017.
 */
@Entity
@Table(name="researcher")
public class Researcher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "researcherID", nullable = false)
    private int researcherId;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "researcher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Idea> ideas;
    @OneToMany(mappedBy = "researcher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Post> posts;


    public int getResearcherId() {
        return researcherId;
    }
    public void setResearcherId(int researcherId) {
        this.researcherId = researcherId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    public Set<Idea> getIdeas() {
        return ideas;
    }
    public void setIdeas(Set<Idea> ideas) {
        this.ideas = ideas;
    }

    @JsonIgnore
    public Set<Post> getPosts() {
        return posts;
    }
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}
