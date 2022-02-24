package car_service.controllers.view;

import car_service.data.entity.History;
import car_service.service.CarService;
import car_service.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/historyView")
public class HistoryViewController {
    private final HistoryService historyService;
    private final CarService carService;

    public HistoryViewController(HistoryService historyService, CarService carService) {
        this.historyService = historyService;
        this.carService = carService;
    }

    @GetMapping
    public String getHistories(Model model) {
        final List<History> histories = historyService.getHistory();
        model.addAttribute("histories", histories);
        return "/history/history";
    }

    @GetMapping("/edit/{id}")
    public String showEditTypeOfServiceForm(Model model, @PathVariable Long id) {
        model.addAttribute("history", historyService.getHistory(id));
        model.addAttribute("cars", carService.getCars());
        return "/history/edit-history";
    }

    @PostMapping("/update/{id}")
    public String updateTypeOfService(Model model, @PathVariable Long id, History history) {
        historyService.updateHistory(history, id);
        return "redirect:/historyView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        historyService.deleteHistory(id);
        return "redirect:/historyView";
    }

}