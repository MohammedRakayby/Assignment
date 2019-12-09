package com.rakayby.assignment;

import com.rakayby.assignment.models.Employee;
import com.rakayby.assignment.services.EmployeeService;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Mohammed.Rakayby
 */
@SpringBootTest
public class RepositoryTest {

    @Autowired
    private EmployeeService employeeService;

    @Disabled("Ignored because of hardcoded size")
    @Test
    void testFindAll() {
        assertEquals(4, employeeService.findAll().size());
    }

    @Test
    void findById() {
        assertTrue(employeeService.findById(1L).isPresent());
    }

    @Test
    void deleteById() {
        employeeService.deleteById(1l);
        assertFalse(employeeService.findById(1l).isPresent());
    }

    @Test
    void update() {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName("test");
        updatedEmployee.setLastName("update");
//        System.out.println(updatedEmployee.toString());
        Employee oldEmployee = employeeService.findById(2L).get();
        Optional result = employeeService.Update(updatedEmployee, 2L);
        Employee fetchedEmployee = (Employee) result.get();

        assertFalse(fetchedEmployee.getFirstName().equalsIgnoreCase(oldEmployee.getFirstName()));
        assertFalse(fetchedEmployee.getLastName().equalsIgnoreCase(oldEmployee.getLastName()));

    }

    @Test
    void create() {
        Employee e = new Employee();
        e.setFirstName("created");
        e.setLastName("employee");
        e.setPhoneNumber("987654321");
        assertTrue(employeeService.create(e).getId() != null);
    }

    @Test
    void findByLastName() {
        assertTrue(employeeService.findByLastName("Rakayby").size() > 0);
    }

    @Test
    void updateEmployeeName() {
//        assertNotNull(employeeService.updateEmployeeName("Updated", "Name", 4L));
        assertTrue(employeeService.updateEmployeeName("Updated", "Name", 4L) > 0);
    }
}
