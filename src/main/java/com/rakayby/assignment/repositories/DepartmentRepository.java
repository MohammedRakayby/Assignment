package com.rakayby.assignment.repositories;

import com.rakayby.assignment.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    //nothing needed more than CRUD therefore, will use spring implementation only.
    @Modifying
    @Query("update DEPARTMENTS set departmentName=?1, managerId=?2 where id=?3")
    public Integer updateDepartment(String departmentName, Long managerId, Long departmentId);
}
