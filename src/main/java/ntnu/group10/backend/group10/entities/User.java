package ntnu.group10.backend.group10.entities;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    private boolean validateField(String field) {
        if (field != null && !field.isBlank() && field.length() > 5) return true;
        return false;
    }

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
