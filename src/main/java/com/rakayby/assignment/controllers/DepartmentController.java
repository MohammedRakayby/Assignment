package com.rakayby.assignment.controllers;

import com.rakayby.assignment.defines.ApiEndPoints;
import com.rakayby.assignment.facades.DepartmentFacade;
import com.rakayby.assignment.models.Department;
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

    @PostMapping(ApiEndPoints.UPDATE)
    public Integer update(@RequestBody Department d, @RequestParam(name = "departmentId", required = true) Long depratmentId) {
        //add validations, create class utils
        return departmentFacade.update(d.getDepartmentName(), d.getManagerId(), depratmentId);
    }

    @GetMapping(ApiEndPoints.DELETE)
    public void delete(@RequestParam(name = "departmentId", required = true) Long departmentId) {
        departmentFacade.deleteById(departmentId);
    }

    @PostMapping(ApiEndPoints.CREATE)
    public Department create(@RequestBody Department d) {
        //validate input
        return departmentFacade.create(d);
    }
}
