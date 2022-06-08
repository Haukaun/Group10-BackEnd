package ntnu.group10.backend.group10.security;

import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Code from GitHub:
 * https://github.com/strazdinsg/app-dev/tree/main/security-demos/05-jwt-authentication/src/main/java/no/ntnu/security
 * The type Access user service.
 * UserDetailsService is an core interface which loads user-specific data.
 */
@Service
public class AccessUserService implements UserDetailsService {


    @Autowired
    UserRepository userRepository;


    /**
     * Checks if user exists and loads users by Username, if they are present.
     *
     * @param username, String username.
     * @return User details.
     * @throws UsernameNotFoundException, Exception gets thrown if username is not found.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        if (user.isPresent()) {
            return new AccessUserDetails(user.get());
        } else {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }

}
