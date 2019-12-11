package com.rakayby.assignment.controllers;

import com.rakayby.assignment.defines.ApiEndPoints;
import com.rakayby.assignment.facades.EmployeeFacade;
import com.rakayby.assignment.models.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.EMPLOYEE, consumes = "application/json", produces = "application/json")
public class EmployeeController {

    private EmployeeFacade employeeFacade;

    @Autowired
    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @GetMapping(ApiEndPoints.GET_ALL)
    public List<Employee> getAll() {
        return employeeFacade.findAll();
    }

    @PostMapping(ApiEndPoints.UPDATE)
    public Employee update(@RequestBody Employee e, @RequestParam(name = "employeeId", required = true) Long employeeId) {
        //add validations, create class utils
        Optional updatedEmployee = employeeFacade.Update(e, employeeId);
        if (updatedEmployee.isPresent()) {
            return (Employee) updatedEmployee.get();
        }
        return null;
    }

    @GetMapping(ApiEndPoints.DELETE)
    public void delete(@RequestParam(name = "employeeId", required = true) Long employeeId) {
        employeeFacade.deleteById(employeeId);
    }

    @PostMapping(ApiEndPoints.CREATE)
    public Employee create(@RequestBody Employee e) {
        //validate input
        return employeeFacade.create(e);
    }
}
