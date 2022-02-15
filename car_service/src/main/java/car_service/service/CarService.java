package car_service.service;

import car_service.data.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarService();

    Car getCarService(long id);

    Car create(Car autoService);

    Car updateCar(Car car, long id);

    void deleteCarService(long id);

    //Ivo
    List<Car> findAllByRegistrationNumberStartsWith(String registrationNumber);
}