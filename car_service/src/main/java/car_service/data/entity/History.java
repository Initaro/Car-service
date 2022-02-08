package car_service.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idHistory;
    private LocalDate dateOfRepair;
    private boolean isPaid;

    public List<TypeOfService> getTypeOfServices() {
        return typeOfServices;
    }

    @ManyToMany(mappedBy = "histories")
    @JsonIgnore
    private List<TypeOfService> typeOfServices;

    public void setIdHistory(long idHistory) {
        this.idHistory = idHistory;
    }

    public void setDateOfRepair(LocalDate dateOfRepair) {
        this.dateOfRepair = dateOfRepair;
    }

    public void setTypeOfServices(List<TypeOfService> typeOfServices) {
        this.typeOfServices = typeOfServices;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @ManyToOne
    private Car car;

    @ManyToMany
    @JsonIgnore
    private List<Employee> employees;

    public History(long idHistory, LocalDate dateOfRepair, boolean isPaid) {
        this.idHistory = idHistory;
        this.dateOfRepair = dateOfRepair;
        this.isPaid = isPaid;
    }

    public History() {}

    public long getIdHistory() {
        return idHistory;
    }

    public LocalDate getDateOfRepair() {
        return dateOfRepair;
    }

    public Car getCar() {
        return car;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}