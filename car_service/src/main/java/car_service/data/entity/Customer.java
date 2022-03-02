package car_service.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCustomers;
    private String name;

    @OneToOne
    @JsonIgnore
    private IdCard idCard;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private List<Car> cars;

    public Customer() {}

    public Customer(long idCustomers, String name, IdCard idCard) {
        this.idCustomers = idCustomers;
        this.name = name;
        this.idCard = idCard;
    }


    public void setIdCustomers(long idCustomers) {
        this.idCustomers = idCustomers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCar() {
        return cars;
    }

    public long getIdCustomers() {
        return idCustomers;
    }

    public String getName() {
        return name;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomers=" + idCustomers +
                ", name='" + name + '\'' +
                ", idCard=" + idCard +
                '}';
    }
}