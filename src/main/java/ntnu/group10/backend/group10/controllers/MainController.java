package ntnu.group10.backend.group10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller()
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "index";
    }
}
