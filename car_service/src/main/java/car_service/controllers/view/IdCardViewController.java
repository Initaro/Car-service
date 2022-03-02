package car_service.controllers.view;

import car_service.data.entity.IdCard;
import car_service.service.CustomerService;
import car_service.service.IdCardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/idCardView")
public class IdCardViewController {
    private final IdCardService idCardService;
    private final CustomerService customerService;

    public IdCardViewController(IdCardService idCardService, CustomerService customerService) {
        this.idCardService = idCardService;
        this.customerService = customerService;
    }

    @GetMapping
    public String getIdCard(Model model){
        final List<IdCard> IdCards=idCardService.getIdCard();
        model.addAttribute("idCards",IdCards);
        return "/idCard/idCard";
    }

    @GetMapping("/edit/{id}")
    public String showEditIdCard(Model model, @PathVariable Long id) {
        model.addAttribute("idCard", idCardService.getIdCard(id));
        model.addAttribute("customers", customerService.getCustomer());
        return "/idCard/edit-idCard";
    }

    @PostMapping("/update/{id}")
    public String updateIdCard(Model model, @PathVariable Long id, IdCard idCard) {
        idCardService.updateIdCard(idCard, id);
        return "redirect:/idCardView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        idCardService.deleteIdCard(id);
        return "redirect:/idCardView";
    }
}
