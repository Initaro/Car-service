package car_service.data.service;

import car_service.data.entity.History;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {
    List<History> getHistory();

    History getHistory(long id);

    History createHistory(History history);

    History updateHistory(History history, long id);

    void deleteHistory(long id);

    //All Toma
    List<History> findByIsPaidOrderByDateOfRepairDesc(boolean isPaid);

    List<History> findByIdHistoryBetweenAndIsPaidFalse(long firstId, long secondId);

    List<History> findByDateOfRepairNotLike(LocalDate dateOfRepair);
}