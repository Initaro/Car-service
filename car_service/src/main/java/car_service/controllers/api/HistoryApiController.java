package car_service.controllers.api;

import car_service.data.entity.History;
import car_service.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class HistoryApiController {

    private final HistoryService historyService;

    public HistoryApiController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping
    public List<History> getHistory() {
        return historyService.getHistory();
    }

    @RequestMapping("/{id}")
    public History getHistory(@PathVariable("id") int id) {
        return historyService.getHistory(id);
    }

    @PostMapping
    public History createHistory(@RequestBody History history) {
        return historyService.createHistory(history);
    }

    @PutMapping(value = "/{id}")
    public History updateHistory(@RequestBody History history, @PathVariable("id") long id) {
        return historyService.updateHistory(history, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteHistory(@PathVariable long id) {
        historyService.deleteHistory(id);
    }

    //All Toma
    @GetMapping("/isPaid/{isPaid}")
    public List<History> findByIsPaidOrderByDateOfRepairDesc(@PathVariable boolean isPaid) {
        return historyService.findByIsPaidOrderByDateOfRepairDesc(isPaid);
    }

    @GetMapping("/firstId/{firstId}/second-id/{secondId}")
    public List<History> findByIdHistoryBetweenAndIsPaidFalse(@PathVariable long firstId, @PathVariable long secondId) {
        return historyService.findByIdHistoryBetweenAndIsPaidFalse(firstId, secondId);
    }

    @GetMapping("/date-of-repair-different/{dateOfRepair}")
    public List<History> findByDateOfRepairNotLike(@PathVariable("dateOfRepair") LocalDate dateOfRepair) {
        return historyService.findByDateOfRepairNotLike(dateOfRepair);
    }

}