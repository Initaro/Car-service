package com.example.car_service.controllers.api;

import com.example.car_service.data.entity.AutoService;
import com.example.car_service.data.service.AutoServiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autoservice")
public class AutoServiceApiController {

    private final AutoServiceService autoServiceService;

    @GetMapping
    public List<AutoService> getAutoService() {
        return autoServiceService.getAutoService();
    }

    @RequestMapping("/{id}")
    public AutoService getAutoService(@PathVariable("id") int id) {
        return autoServiceService.getAutoService(id);
    }

    @PostMapping
    public AutoService createAutoService(@RequestBody AutoService autoService) {
        return autoServiceService.create(autoService);
    }


    public AutoServiceApiController(AutoServiceService autoServiceService) {
        this.autoServiceService = autoServiceService;
    }

    public AutoServiceService getAutoServiceService() {
        return autoServiceService;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAutoService(@PathVariable long id) {
        autoServiceService.deleteAutoService(id);
    }
}
