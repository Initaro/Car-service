package car_service.service.implementation;

import car_service.data.entity.History;
import car_service.data.repository.HistoryRepository;
import car_service.service.HistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<History> findByDateOfRepairNotLike(LocalDate dateOfRepair) {
        return historyRepository.findByDateOfRepairNotLike(dateOfRepair);
    }

}