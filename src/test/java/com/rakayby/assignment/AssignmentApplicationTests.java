//package com.rakayby.assignment;
//
//import com.rakayby.assignment.models.Employee;
//import com.rakayby.assignment.services.EmployeeService;
//import java.util.List;
//import org.assertj.core.api.Assert;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//class AssignmentApplicationTests {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Test
//    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
//        List<Employee> employees = employeeService.findAll();
//
//        Assert.assertEquals(employees.size(), 3);
//    }
//
//}
