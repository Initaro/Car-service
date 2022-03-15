package car_service.service.implementation;

import car_service.data.entity.Car;
import car_service.data.entity.Customer;
import car_service.data.entity.History;
import car_service.data.repository.CarRepository;
import car_service.service.CarService;
import car_service.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImplementation implements CarService {

    private final CarRepository carRepository;

    private final CustomerService customerService;
    public CarServiceImplementation(CarRepository autoServiceRepository, CustomerService customerService) {
        this.carRepository = autoServiceRepository;
        this.customerService = customerService;
    }

    public CarRepository getAutoServiceRepository() {
        return carRepository;
    }

    @Override
    public List<Car> getCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCars(long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid carservice id: " + id));
    }

    @Override
    public Car create(Car autoService) {
        return carRepository.save(autoService);
    }

    @Override
    public Car updateCar(Car car, long id) {
        car.setId(id);

        return carRepository.save(car);
    }

    @Override
    public void deleteCar(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findAllByRegistrationNumberStartsWith(String registrationNumber) {
        return carRepository.findAllByRegistrationNumberStartsWith(registrationNumber);
    }


    @Override
    public List<Car> getCarsByCustomer(long id) {
        Customer customer = customerService.getCustomer(id);
        List<Car> cars = customer.getCars();

        return cars;
    }
}