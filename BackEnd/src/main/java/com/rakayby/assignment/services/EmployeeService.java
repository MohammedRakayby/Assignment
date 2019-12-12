package com.rakayby.assignment.services;

import com.rakayby.assignment.models.Employee;
import com.rakayby.assignment.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class EmployeeService {

    private static final Logger debugLogger = LogManager.getLogger("DEBUG");
    private static final Logger errorLogger = LogManager.getLogger("ERROR");
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        debugLogger.debug("@Service EmployeeService, calling method findAll");
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long Id) {
        debugLogger.debug("@Service EmployeeService, calling method findById");
        return employeeRepository.findById(Id);
    }

    public void deleteById(Long Id) {
        debugLogger.debug("@Service EmployeeService, calling method deleteById");
        employeeRepository.deleteById(Id);
    }

    public void delete(Employee e) {
        debugLogger.debug("@Service EmployeeService, calling method delete");
        employeeRepository.delete(e);
    }

    public Employee create(Employee e) {
        debugLogger.debug("@Service EmployeeService, calling method create");
        return employeeRepository.save(e);
    }

    public Optional<Employee> Update(Employee e, Long Id) {
        debugLogger.debug("@Service EmployeeService, calling method Update");
        Optional opt = employeeRepository.findById(Id);
        if (opt.isPresent()) {
            Employee employee = (Employee) opt.get();
            updateExistingEmployee(employee, e);
            employeeRepository.save(employee);
            debugLogger.debug("@Service EmployeeService, updated employee {}, ID: {} ", employee.getFirstName() + " " + employee.getLastName(), employee.getId());
            return Optional.of(employee);
        } else {
            errorLogger.error("@Service EmployeeService, method Update failed to update employee with ID {}", Id);
            return Optional.empty();
        }
    }

    @Transactional
    public Integer updateEmployeeName(String firstName, String lastName, Long Id) {
        debugLogger.debug("@Service EmployeeService, calling method updateEmployeeName");
        return employeeRepository.updateEmployeeName(firstName, lastName, Id);
    }

    public List<Employee> findByLastName(String lastName) {
        debugLogger.debug("@Service EmployeeService, calling method findByLastName");
        return employeeRepository.findByLastname(lastName);
    }

    private void updateExistingEmployee(Employee target, Employee source) {
        debugLogger.debug("@Service EmployeeService, calling method updateExistingEmployee");
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setDepartmentId(source.getDepartmentId());
        target.setHiringDate(source.getHiringDate());
        target.setEmail(source.getEmail());
        target.setManagerId(source.getManagerId());
        target.setPhoneNumber(source.getPhoneNumber());
        target.setSalary(source.getSalary());
    }
}
