package com.rakayby.assignment.services;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.repositories.DepartmentRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammed.Rakayby
 */
@Service
public class DepartmentService {

    private static final Logger debugLogger = LogManager.getLogger("DEBUG");
    private static final Logger errorLogger = LogManager.getLogger("ERROR");
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        debugLogger.debug("@Service DepartmentService, calling method findAll");
        return departmentRepository.findAll();
    }

    public Optional<Department> findById(Long Id) {
        debugLogger.debug("@Service DepartmentService, calling method findById");
        return departmentRepository.findById(Id);
    }

    public void deleteById(Long Id) {
        debugLogger.debug("@Service DepartmentService, calling method deleteById");
        departmentRepository.deleteById(Id);
    }

    public void delete(Department e) {
        debugLogger.debug("@Service DepartmentService, calling method delete");
        departmentRepository.delete(e);
    }

    public Department create(Department e) {
        debugLogger.debug("@Service DepartmentService, calling method create");
        return departmentRepository.save(e);
    }

    @Transactional
    public Integer update(String departmentName, Long managerId, Long departmentId) {
        debugLogger.debug("@Service DepartmentService, calling method update");
        return departmentRepository.updateDepartment(departmentName, managerId, departmentId);
    }
}
