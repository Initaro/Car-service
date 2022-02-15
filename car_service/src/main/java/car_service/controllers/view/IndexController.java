package car_service.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the School Management System!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }
}