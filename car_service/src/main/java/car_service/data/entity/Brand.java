package car_service.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBrands;
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonIgnore
    private List<Car> Cars;

    @ManyToMany(mappedBy = "brand")
    @JsonIgnoreProperties("brand")
    private List<AutoService> autoServices;

    public Brand(long idBrands, String name) {
        this.idBrands = idBrands;
        this.name = name;
    }

    public List<Car> getCars() {
        return Cars;
    }

    public List<AutoService> getAutoServices() {
        return autoServices;
    }

    public Brand() {}

    public long getIdBrands() {
        return idBrands;
    }

    public void setIdBrands(long idBrands) {
        this.idBrands = idBrands;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}