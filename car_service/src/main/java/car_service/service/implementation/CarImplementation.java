package car_service.service.implementation;

import car_service.data.entity.Car;
import car_service.data.repository.CarRepository;
import car_service.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImplementation implements CarService {

    private final CarRepository carRepository;

    public CarImplementation(CarRepository autoServiceRepository) {
        this.carRepository = autoServiceRepository;
    }

    public CarRepository getAutoServiceRepository() {
        return carRepository;
    }

    @Override
    public List<Car> getCarService() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarService(long id) {
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
    public void deleteCarService(long id) {
        carRepository.deleteById(id);
    }

    @Override
    public List<Car> findAllByRegistrationNumberStartsWith(String registrationNumber) {
        return carRepository.findAllByRegistrationNumberStartsWith(registrationNumber);
    }

}