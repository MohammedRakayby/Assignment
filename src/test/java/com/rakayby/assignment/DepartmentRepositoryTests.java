/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakayby.assignment;

import com.rakayby.assignment.facades.DepartmentFacade;
import com.rakayby.assignment.facades.EmployeeFacade;
import com.rakayby.assignment.models.Department;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Mohammed.Rakayby
 */
@SpringBootTest
public class DepartmentRepositoryTests {

    @Autowired
    private DepartmentFacade departmentFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Test
    void testFindAll() {
        assertTrue(departmentFacade.findAll().size() > 0);
    }

    @Test
    void findById() {
        assertTrue(departmentFacade.findById(1L).isPresent());
    }

    @Test
    void deleteById() {
        departmentFacade.deleteById(4L);
        assertFalse(departmentFacade.findById(4L).isPresent());
    }

    @Test
    void update() {
        assertTrue(departmentFacade.update("test", 5L, 2L) > 0);
    }

    @Test
    void create() {
        Department e = new Department();
        e.setDepartmentName("created");
        e.setManagerId(1L);
        assertTrue(departmentFacade.create(e).getId() != null);
    }

    @Disabled   //other tests checking for department with id=1 will fail if enabled
    @Test
    void checkCustomerAfterDepartmentDelete() {
        departmentFacade.deleteById(1L);
        assertFalse(employeeFacade.findById(1L).isPresent());
    }
}
