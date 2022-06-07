package ntnu.group10.backend.group10.controllers;


import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * The type User controller. Controller class is responsible for processing incoming
 * REST API requests, preparing model, and return response.
 */
@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Post method for registering user.
     * Sends Response based on the User being valid.
     * Created 201, if user is added.
     * Conflict 409, if user is not valid.
     * Bad request 400, if user input is wrong.
     * @param user, User entity.
     * @return the response entity
     */
    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        ResponseEntity<String> response = new ResponseEntity<>("Username and password must be at least 6 characters.", HttpStatus.BAD_REQUEST);
        if (user.isValid()) {
            try {
                userService.addUser(user);
                response = new ResponseEntity<>(HttpStatus.CREATED);
            } catch(IllegalArgumentException e) {
                response = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            }

        }
        return response;
    }

    /**
     * Gets user details.
     * Request only for ROLE_CUSTOMER and ROLE_ADMIN.
     * @return the user details
     */
    @GetMapping("/myuser")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
    public @ResponseBody String getUserDetails() {
        return userService.getUser();
    }
}
