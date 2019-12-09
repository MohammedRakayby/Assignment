package com.rakayby.assignment.services;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.repositories.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long Id) {
        return departmentRepository.findById(Id);
    }

    public void deleteById(Long Id) {
        departmentRepository.deleteById(Id);
    }

    public void delete(Department e) {
        departmentRepository.delete(e);
    }

    public Department create(Department e) {
        return departmentRepository.save(e);
    }

    public Integer update(String departmentName, Long managerId, Long departmentId) {
        return departmentRepository.updateDepartment(departmentName, managerId, departmentId);
    }
}
