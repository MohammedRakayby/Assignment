/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakayby.assignment;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.services.DepartmentService;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    private DepartmentService departmentService;

    @Test
    void testFindAll() {
        assertTrue(departmentService.findAll().size() > 0);
    }

    @Test
    void findById() {
        assertTrue(departmentService.findById(1L).isPresent());
    }

    @Test
    void deleteById() {
        departmentService.deleteById(4L);
        assertFalse(departmentService.findById(4L).isPresent());
    }

    @Test
    void update() {
        assertTrue(departmentService.update("test", 5L, 2L) > 0);
    }

    @Test
    void create() {
        Department e = new Department();
        e.setDepartmentName("created");
        e.setManagerId(1L);
        assertTrue(departmentService.create(e).getId() != null);
    }
}
