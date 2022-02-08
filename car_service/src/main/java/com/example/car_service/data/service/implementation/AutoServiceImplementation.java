package com.example.car_service.data.service.implementation;

import com.example.car_service.data.entity.AutoService;
import com.example.car_service.data.repository.AutoServiceRepository;
import com.example.car_service.data.service.AutoServiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImplementation implements AutoServiceService {

    private final AutoServiceRepository autoServiceRepository;

    public AutoServiceImplementation(AutoServiceRepository autoServiceRepository) {
        this.autoServiceRepository = autoServiceRepository;
    }

    public AutoServiceRepository getAutoServiceRepository() {
        return autoServiceRepository;
    }

    @Override
    public List<AutoService> getAutoService() {
        return autoServiceRepository.findAll();
    }

    @Override
    public AutoService getAutoService(long id) {
        return autoServiceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid autoservice id: " + id));
    }

    @Override
    public AutoService create(AutoService autoService) {
        return autoServiceRepository.save(autoService);
    }

    @Override
    public void deleteAutoService(long id) {
        autoServiceRepository.deleteById(id);
    }

}
