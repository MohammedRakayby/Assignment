package com.rakayby.assignment;

import com.rakayby.assignment.facades.EmployeeFacade;
import com.rakayby.assignment.models.Employee;
import java.util.Optional;
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
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeFacade emplyeeFacade;

    @Disabled("Ignored because of hardcoded size")
    @Test
    void testFindAll() {
        assertEquals(4, emplyeeFacade.findAll().size());
    }

    @Test
    void findById() {
        assertTrue(emplyeeFacade.findById(1L).isPresent());
    }

    @Test
    void deleteById() {
        emplyeeFacade.deleteById(9l);
        assertFalse(emplyeeFacade.findById(9l).isPresent());
    }

    @Test
    void update() {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName("test");
        updatedEmployee.setLastName("update");
//        System.out.println(updatedEmployee.toString());
        Employee oldEmployee = emplyeeFacade.findById(2L).get();
        Optional result = emplyeeFacade.Update(updatedEmployee, 2L);
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
        assertTrue(emplyeeFacade.create(e).getId() != null);
    }

    @Test
    void findByLastName() {
        System.out.println(emplyeeFacade.findByLastName("Rakayby").get(0).toString());
        assertTrue(emplyeeFacade.findByLastName("Rakayby").size() > 0);
    }

    @Test
    void updateEmployeeName() {
//        assertNotNull(employeeService.updateEmployeeName("Updated", "Name", 4L));
        assertTrue(emplyeeFacade.updateEmployeeName("Updated", "Name", 2L) > 0);
    }

    @Test
    void getEmployeeDepartment() {
        assertNotNull(emplyeeFacade.findById(1L).get().getDepartmentId());
    }
}
