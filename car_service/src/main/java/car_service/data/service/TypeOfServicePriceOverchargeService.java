package car_service.data.service;

import car_service.data.entity.TypeOfServicePriceOvercharge;

import java.util.List;

public interface TypeOfServicePriceOverchargeService {

    List<TypeOfServicePriceOvercharge> getTypeOfServicePriceOvercharge();

    TypeOfServicePriceOvercharge getTypeOfServicePriceOvercharge(long id);

    TypeOfServicePriceOvercharge createTypeOfServicePriceOvercharge(TypeOfServicePriceOvercharge typeOfServicePriceOvercharge);

    TypeOfServicePriceOvercharge updateTypeOfServicePriceOvercharge(TypeOfServicePriceOvercharge typeOfServicePriceOvercharge, long id);

    void deleteTypeOfServicePriceOvercharge(long id);
}
