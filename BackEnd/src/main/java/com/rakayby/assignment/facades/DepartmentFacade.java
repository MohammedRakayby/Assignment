package com.rakayby.assignment.facades;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.services.DepartmentService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Mohammed.Rakayby
 */
@Component
public class DepartmentFacade {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentFacade(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public List<Department> findAll() {
        return departmentService.findAll();
    }

    public Optional<Department> findById(Long Id) {
        return departmentService.findById(Id);
    }

    public void deleteById(Long Id) {
        departmentService.deleteById(Id);
    }

    public void delete(Department e) {
        departmentService.delete(e);
    }

    public Department create(Department e) {
        return departmentService.create(e);
    }

    @Transactional
    public Integer update(String departmentName, Long managerId, Long departmentId) {
        return departmentService.update(departmentName, managerId, departmentId);
    }
}
