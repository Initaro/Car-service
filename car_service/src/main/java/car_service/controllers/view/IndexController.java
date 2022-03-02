package car_service.controllers.view;

import car_service.data.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String getIndex(Model model) {
        final String welcomeMessage = "Welcome to the service System!";
        model.addAttribute("welcome", welcomeMessage);
        return "index";
    }
//    @GetMapping("login")
//    public String login(Model model) {
//        final String welcomeMessage = "WELCOME TO THE CAR SERVICE!";
//        model.addAttribute("welcome", welcomeMessage);
//        return "login";
//    }

    @GetMapping("unauthorized")
    public String unauthorized(Model model) {
        final String welcomeMessage = "WELCOME TO THE CAR SERVICE!";
        model.addAttribute("welcome", welcomeMessage);
        return "unauthorized";
    }

}