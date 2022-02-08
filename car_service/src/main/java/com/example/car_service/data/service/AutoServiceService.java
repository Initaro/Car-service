package com.example.car_service.data.service;


import com.example.car_service.data.entity.AutoService;

import java.util.List;

public interface AutoServiceService {

    List<AutoService> getAutoService();

    AutoService getAutoService(long id);

    AutoService create(AutoService autoService);

    void deleteAutoService(long id);

}
