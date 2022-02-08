package car_service.data.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class TypeOfService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeOfService;
    private double price;
    private String type;
    private String description;

    @ManyToMany
    private List<History> histories;

    @ManyToMany
    private List<Employee> employees;

    @ManyToMany
    private List<AutoService> autoServices;

    public TypeOfService(long idTypeOfService, double price, String type, String description, List<History> histories, List<Employee> employees, List<AutoService> autoServices) {
        this.idTypeOfService = idTypeOfService;
        this.price = price;
        this.type = type;
        this.description = description;
        this.histories = histories;
        this.employees = employees;
        this.autoServices = autoServices;
    }

    public TypeOfService() {}

    public void setIdTypeOfService(long idTypeOfService) {
        this.idTypeOfService = idTypeOfService;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setAutoServices(List<AutoService> autoServices) {
        this.autoServices = autoServices;
    }

    public long getIdTypeOfService() {
        return idTypeOfService;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public List<History> getHistories() {
        return histories;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<AutoService> getAutoServices() {
        return autoServices;
    }
}