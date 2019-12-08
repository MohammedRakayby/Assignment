package com.rakayby.assignment.repositories;

import com.rakayby.assignment.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammed.Rakayby
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //nothing needed more than CRUD therefore, will use spring implementation only.
    //so this interface will not include any new methods in my case.
    //however, more business logic could be added here if needed.
}
