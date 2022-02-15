package car_service.service.implementation;

import car_service.data.entity.*;
import car_service.data.repository.HistoryRepository;
import car_service.service.HistoryService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryImplementation implements HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryImplementation(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    @Override
    public List<History> getHistory() {
        return historyRepository.findAll();
    }

    @Override
    public History getHistory(long id) {
        return historyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid history id: " + id));
    }

    @Override
    public History createHistory(History history) {
        return historyRepository.save(history);
    }

    @Override
    public History updateHistory(History history, long id) {
        history.setIdHistory(id);

        return historyRepository.save(history);
    }

    @Override
    public void deleteHistory(long id) {
        historyRepository.deleteById(id);
    }

    @Override
    public List<History> findByIsPaidOrderByDateOfRepairDesc(boolean isPaid) {
        return historyRepository.findByIsPaidOrderByDateOfRepairDesc(isPaid);
    }

    @Override
    public List<History> findByIdHistoryBetweenAndIsPaidFalse(long firstId, long secondId) {
        return historyRepository.findByIdHistoryBetweenAndIsPaidFalse(firstId, secondId);
    }

    @Override
    public BigDecimal findFinalPriceByBrand(long idHistory) {
        History history = historyRepository.getById(idHistory);
        Car car = history.getCar();
        Brand brand = car.getBrand();
        List<TypeOfService> typeOfServices = history.getTypeOfServices();
        BigDecimal finalPrice=BigDecimal.valueOf(0);
        List<TypeOfServicePriceOvercharge> typeOfServicePriceOvercharges = new ArrayList<>();
        for (TypeOfService typeOfService1 : typeOfServices) {
            typeOfServicePriceOvercharges.addAll(typeOfService1.getTypeOfServicePriceOvercharges());

        }
        for (TypeOfServicePriceOvercharge typeOfServicePriceOvercharge1 : typeOfServicePriceOvercharges) {
            for (TypeOfService typeOfService1 : typeOfServices) {
                if (brand.equals(typeOfServicePriceOvercharge1.getBrand())) {
                    finalPrice = typeOfServicePriceOvercharge1.getBrandOvercharge().divide(BigDecimal.valueOf(100)).multiply(BigDecimal.valueOf(typeOfService1.getPrice()));
                    finalPrice =finalPrice.add(BigDecimal.valueOf(typeOfService1.getPrice()));
                }
            }
        }

        return finalPrice;
    }

    @Override
    public List<History> findByDateOfRepairNotLike(LocalDate dateOfRepair) {
        return historyRepository.findByDateOfRepairNotLike(dateOfRepair);
    }

}