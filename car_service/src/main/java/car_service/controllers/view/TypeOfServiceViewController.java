package car_service.controllers.view;

import car_service.data.entity.Customer;
import car_service.data.entity.TypeOfService;
import car_service.service.TypeOfServiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/typeOfServiceView")
public class TypeOfServiceViewController {

    private final TypeOfServiceService typeOfServiceService;

    public TypeOfServiceViewController(TypeOfServiceService typeOfServiceService) {
        this.typeOfServiceService = typeOfServiceService;
    }

    @GetMapping
    public String getTypeOfService(Model model) {
        final List<TypeOfService> typeOfServices = typeOfServiceService.getTypeOfService();
        model.addAttribute("typeOfServices", typeOfServices);
        return "/typeOfService/typeOfService";
    }

    @GetMapping("/edit-type-of-service")
    public String showCreateTypeOfService(Model model) {
        model.addAttribute("typeOfService", new TypeOfService());
        return "/typeOfService/create-type-of-service";
    }

    @PostMapping("/create")
    public String createTypeOfService(Model model, TypeOfService typeOfService) {
        typeOfServiceService.createTypeOfService(typeOfService);
        return "redirect:/typeOfServiceView";
    }

    @GetMapping("/edit/{id}")
    public String showEditTypeOfServiceForm(Model model, @PathVariable Long id) {
        model.addAttribute("typeOfService", typeOfServiceService.getTypeOfService(id));
        return "/typeOfService/edit-type-of-service";
    }

    @PostMapping("/update/{id}")
    public String updateTypeOfService(Model model, @PathVariable Long id, TypeOfService typeOfService) {
        typeOfServiceService.updateTypeOfService(typeOfService, id);
        return "redirect:/typeOfServiceView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        typeOfServiceService.deleteTypeOfService(id);
        return "redirect:/typeOfServiceView";
    }
}