package com.rakayby.assignment.services;

import com.rakayby.assignment.models.Employee;
import com.rakayby.assignment.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long Id) {
        return employeeRepository.findById(Id);
    }

    public void deleteById(Long Id) {
        employeeRepository.deleteById(Id);
    }

    public void delete(Employee e) {
        employeeRepository.delete(e);
    }

    public Employee create(Employee e) {
        return employeeRepository.save(e);
    }

    public Optional<Employee> Update(Employee e, Long Id) {
        Optional opt = employeeRepository.findById(Id);
        if (opt.isPresent()) {
            Employee employee = (Employee) opt.get();
            updateExistingEmployee(employee, e);
            employeeRepository.save(employee);
            return Optional.of(employee);
        } else {
            return Optional.empty();
        }
    }

    public Integer updateEmployeeName(String firstName, String lastName, Long Id) {
        return employeeRepository.updateEmployeeName(firstName, lastName, Id);
    }

    public List<Employee> findByLastName(String lastName) {
        return employeeRepository.findByLastname(lastName);
    }

    private void updateExistingEmployee(Employee target, Employee source) {
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDepartment(source.getDepartment());
        target.setHiringDate(source.getHiringDate());
        target.setEmail(source.getEmail());
        target.setManagerId(source.getManagerId());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setSalary(source.getSalary());
    }
}
