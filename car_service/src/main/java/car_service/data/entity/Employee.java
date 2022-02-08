package car_service.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployees;
    private String name;
    private String address;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnoreProperties("employees")
    private List<TypeOfService> typeOfServices;

    @ManyToMany(mappedBy = "employees")
    @JsonIgnoreProperties("employees")
    private List<History> histories;

    @ManyToOne
    private AutoService autoService;

    public Employee(long idEmployees, String name, String address) {
        this.idEmployees = idEmployees;
        this.name = name;
        this.address = address;
    }

    public Employee() {}

    public List<TypeOfService> getTypeOfServices() {
        return typeOfServices;
    }

    public List<History> getHistories() {
        return histories;
    }

    public AutoService getAutoService() {
        return autoService;
    }

    public long getIdEmployees() {
        return idEmployees;
    }

    public void setIdEmployees(long idEmployees) {
        this.idEmployees = idEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}