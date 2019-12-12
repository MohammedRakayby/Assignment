package com.rakayby.assignment.facades;

import com.rakayby.assignment.models.Employee;
import com.rakayby.assignment.services.EmployeeService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohammed.Rakayby
 */
@Component
public class EmployeeFacade {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeFacade(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    public Optional<Employee> findById(Long Id) {
        return employeeService.findById(Id);
    }

    public void deleteById(Long Id) {
        employeeService.deleteById(Id);
    }

    public void delete(Employee e) {
        employeeService.delete(e);
    }

    public Employee create(Employee e) {
        return employeeService.create(e);
    }

    public Optional<Employee> Update(Employee e, Long Id) {
        return employeeService.Update(e, Id);
    }

    @Transactional
    public Integer updateEmployeeName(String firstName, String lastName, Long Id) {
        return employeeService.updateEmployeeName(firstName, lastName, Id);
    }

    public List<Employee> findByLastName(String lastName) {
        return employeeService.findByLastName(lastName);
    }

}
