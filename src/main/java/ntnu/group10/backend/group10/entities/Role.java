package ntnu.group10.backend.group10.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Part of code taken from GitHub:
 * https://github.com/strazdinsg/app-dev/blob/main/security-demos/05-jwt-authentication/src/main/java/no/ntnu/models/Role.java
 *
 * Role Entity Class.
 */
@Entity(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new LinkedHashSet<>();

    /**
     * Instantiates a new Role.
     */
    public Role() {

    }

    /**
     * Instantiates a new Role.
     *
     * @param name the name
     */
    public Role(String name) {
        this.name = name;
    }

    /**
     * Gets id of role.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of role.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Sets users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * Gets name of user.
     *
     * @return given name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of user.
     *
     * @param name, the name of user
     */
    public void setName(String name) {
        this.name = name;
    }
}
