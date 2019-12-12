package com.rakayby.assignment.controllers;

import com.rakayby.assignment.common.Utility;
import com.rakayby.assignment.defines.ApiEndPoints;
import com.rakayby.assignment.facades.DepartmentFacade;
import com.rakayby.assignment.models.Department;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
@RequestMapping(value = ApiEndPoints.Controllers.DEPARTMENT, produces = "application/json")
public class DepartmentController {

    private DepartmentFacade departmentFacade;

    @Autowired
    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @GetMapping(ApiEndPoints.GET_ALL)
    @ApiOperation(value = "Fetches all departments")
    public List<Department> getAll() {
        return departmentFacade.findAll();
    }

    @PostMapping(ApiEndPoints.UPDATE)
    @ApiOperation(value = "Updates department",
            notes = "Updates certain department by Id,",
            response = Integer.class)
    public Integer update(@RequestBody Department d, @RequestParam(name = "departmentId", required = true) Long depratmentId) {
        if (Utility.validateDepartment(d)) {
            return departmentFacade.update(d.getDepartmentName(), d.getManagerId(), depratmentId);
        }
        return 0;
    }

    @ApiOperation(value = "Deletes department",
            notes = "Delete certain department by Id",
            response = Void.class)
    @GetMapping(ApiEndPoints.DELETE)
    public void delete(@RequestParam(name = "departmentId", required = true) Long departmentId) {
        departmentFacade.deleteById(departmentId);
    }

    @PostMapping(ApiEndPoints.CREATE)
    @ApiOperation(value = "Create department",
            notes = "You can delete the id param from the model, the id is generated automatically",
            response = Department.class)
    public Department create(@RequestBody Department d) {
        if (Utility.validateDepartment(d)) {
            return departmentFacade.create(d);
        }
        return null;
    }
}
