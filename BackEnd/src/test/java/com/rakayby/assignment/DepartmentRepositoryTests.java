/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakayby.assignment;

import com.rakayby.assignment.facades.DepartmentFacade;
import com.rakayby.assignment.facades.EmployeeFacade;
import com.rakayby.assignment.models.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger("DEBUG");
    @Autowired
    private DepartmentFacade departmentFacade;

    @Autowired
    private EmployeeFacade employeeFacade;

    @Test
    void testFindAll() {
        logger.debug("Running  DepartmentRepositoryTests @test testFindAll");
        assertTrue(departmentFacade.findAll().size() > 0);
    }

    @Test
    void findById() {
        logger.debug("Running  DepartmentRepositoryTests @test findById");
        assertTrue(departmentFacade.findById(1L).isPresent());
    }

    @Test
    void deleteById() {
        logger.debug("Running DepartmentRepositoryTests @test deleteById");
        departmentFacade.deleteById(4L);
        assertFalse(departmentFacade.findById(4L).isPresent());
    }

    @Test
    void update() {
        logger.debug("Running DepartmentRepositoryTests @test update");
        assertTrue(departmentFacade.update("test", 5L, 2L) > 0);
    }

    @Test
    void create() {
        logger.debug("Running DepartmentRepositoryTests @test create");
        Department e = new Department();
        e.setDepartmentName("created");
        e.setManagerId(1L);
        assertTrue(departmentFacade.create(e).getId() != null);
    }

    @Disabled   //other tests checking for department with id=1 will fail if enabled
    @Test
    void checkCustomerAfterDepartmentDelete() {
        logger.debug("Running DepartmentRepositoryTests @test checkCustomerAfterDepartmentDelete");
        departmentFacade.deleteById(1L);
        assertFalse(employeeFacade.findById(1L).isPresent());
    }
}
