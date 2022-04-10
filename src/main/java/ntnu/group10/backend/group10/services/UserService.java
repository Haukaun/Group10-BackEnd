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

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public void addUser(User user) {
        if (userRepository.findByUserName(user.getUserName()).isEmpty()) {
            Role role = new Role("ROLE_CUSTOMER");

            user.addRole(role);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            roleRepository.save(role);
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Username or email already in use.");
        }
    }

    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User currentUser = userRepository.findByUserName(currentPrincipalName).get();

        return currentUser.toString();
    }
}