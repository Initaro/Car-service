package car_service.controllers.api;

import car_service.data.entity.*;
import car_service.data.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {

    private final CustomerService customerService;

    public CustomerApiController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @RequestMapping("/{id}")
    public Customer getCustomer(@PathVariable("id") int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
    }

    //Toma
    @GetMapping("/customer-bill/idCustomers/{idCustomers}")
    public Double findCustomerBill(@PathVariable("idCustomers") long idCustomers) {
        return customerService.findCustomerBill(idCustomers);
    }

    //Kiril
    @GetMapping("/id/{id}")
    public List<Customer> findAllByIdGreaterThanEqual(@PathVariable("id") long idCustomers) {
        return customerService.findAllByIdGreaterThanEqual(idCustomers);
    }

    //Kiril
    @GetMapping("/customer-bill-before-date/idCustomers/{idCustomers}/dateOfRepair/{dateOfRepair}")
    public Double findCustomerBillBeforeDate(@PathVariable("idCustomers") long idCustomers, @PathVariable("dateOfRepair") LocalDate dateOfRepair) {
        return customerService.findCustomerBillBeforeDate(idCustomers, dateOfRepair);
    }

}