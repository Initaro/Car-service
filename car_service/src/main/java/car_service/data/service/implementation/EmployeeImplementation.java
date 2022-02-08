package car_service.data.service.implementation;

import car_service.data.entity.Employee;
import car_service.data.repository.EmployeeRepository;
import car_service.data.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeImplementation implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee id: " + id));
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        employee.setIdEmployees(id);

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByNameAndAddress(String name, String address) {
        return employeeRepository.findAllByNameAndAddress(name, address);
    }

}