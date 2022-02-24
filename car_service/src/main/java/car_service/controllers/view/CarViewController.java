package car_service.controllers.view;

import car_service.data.entity.Car;
import car_service.data.entity.Employee;
import car_service.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carView")
public class CarViewController {
private final CarService carService;

    public CarViewController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
public String getCar(Model model){
        final List<Car> cars=carService.getCars();
        model.addAttribute("cars",cars);
        return "/car/car";
    }

    @GetMapping("/edit/{id}")
    public String showEditCar(Model model, @PathVariable Long id) {
        model.addAttribute("car", carService.getCars(id));
        return "/car/edit-car";
    }

    @PostMapping("/update/{id}")
    public String updateCar(Model model, @PathVariable Long id, Car car) {
        carService.updateCar(car, id);
        return "redirect:/carView";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        carService.deleteCar(id);
        return "redirect:/carView";
    }
}
