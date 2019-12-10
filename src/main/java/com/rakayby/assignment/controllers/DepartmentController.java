package com.rakayby.assignment.controllers;

import com.rakayby.assignment.defines.ApiEndPoints;
import com.rakayby.assignment.facades.DepartmentFacade;
import com.rakayby.assignment.models.Department;
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

    private DepartmentFacade departmentFacade;

    @Autowired
    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @GetMapping(ApiEndPoints.GET_ALL)
    public List<Department> getAll() {
        return departmentFacade.findAll();
    }
}
