package ntnu.group10.backend.group10.services;

import ntnu.group10.backend.group10.entities.Role;
import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.repository.RoleRepository;
import ntnu.group10.backend.group10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 *User service. Service class which handles CRUD logic for User.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    /**
     * Add user.
     * If username and email don't exist, user gets role as customer, encodes password and adds user.
     *
     * @param user, Entity class for User.
     */
    public void addUser(User user) {
        if (userRepository.findByUserName(user.getUserName()).isEmpty() && userRepository.findByEmail(user.getEmail()).isEmpty()) {
            Role role = new Role("ROLE_CUSTOMER");

            user.addRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            roleRepository.save(role);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Username or email already in use.");
        }
    }

    /**
     * Gets current user details.
     *
     * @return the current user details
     */
    public User getCurrentUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Optional<User> optionalCurrentUser = userRepository.findByUserName(currentPrincipalName);

        return optionalCurrentUser.orElse(null);
    }

    /**
     * Gets user in string format.
     *
     * @return the user as string
     */
    public String getUser() {
        return getCurrentUserDetails().toString();
    }
}
