package com.rakayby.assignment.controllers;

import com.rakayby.assignment.defines.ApiEndPoints;
import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.services.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mohammed.Rakayby
 */
@RestController
@RequestMapping(value = ApiEndPoints.Controllers.DEPARTMENT, consumes = "application/json", produces = "application/json")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(ApiEndPoints.GET_ALL)
    public List<Department> getAll() {
        return departmentService.findAll();
    }
}
