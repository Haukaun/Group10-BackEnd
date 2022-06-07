package ntnu.group10.backend.group10.entities;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User Entity Class.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    private String password;

    @Column(unique = true)
    private String email;
    private boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name="user_id")
    )
    private Set<Role> roles = new LinkedHashSet<>();

    /**
     * Gets email of user.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email of user.
     *
     * @param email, the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets active.
     *
     * @param active, true or false
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Gets roles of user.
     *
     * @return the roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets roles of user.
     *
     * @param roles, which role.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Add role.
     *
     * @param role, the role of user
     */
    public void addRole(Role role) {
        this.roles.add(role);
    }

    /**
     * Gets id of user.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id of user.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets username of user.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets username of user.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password of user.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password of user.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if user is active.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return active;
    }





    private boolean validateField(String field) {
        if (field != null && !field.isBlank() && field.length() > 5) return true;
        return false;
    }

    /**
     * Checks if user input is valid using regex.
     *
     * @return the boolean, true if correct input.
     */
    public boolean isValid() {
        if (validateField(userName) && validateField(password)) {
            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                return true;
            }
        }
        return false;
    }



    public String toString() {
        JSONObject details = new JSONObject();
        details.put("id", this.id);
        details.put("userName", this.userName);
        details.put("email", this.email);

        JSONArray roleArray = new JSONArray();
        this.roles.forEach(role -> roleArray.put(role.getName()));
        details.put("roles", roleArray);

        return details.toString();
    }
}
