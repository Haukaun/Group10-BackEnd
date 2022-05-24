package ntnu.group10.backend.group10.controllers;


import ntnu.group10.backend.group10.entities.User;
import ntnu.group10.backend.group10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        ResponseEntity<String> response = new ResponseEntity<>("User input not valid.", HttpStatus.BAD_REQUEST);
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

    @GetMapping("/myuser")
    @PreAuthorize("hasRole('ROLE_CUSTOMER') or hasRole('ROLE_ADMIN')")
    public @ResponseBody String getUserDetails() {
        return userService.getUser();
    }
}
