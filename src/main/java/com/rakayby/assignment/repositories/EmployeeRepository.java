package com.rakayby.assignment.repositories;

import com.rakayby.assignment.models.Employee;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammed.Rakayby
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //nothing needed more than CRUD therefore, will use spring implementation only.
    @Query("select e from EMPLOYEES e where e.lastName = last_name")
    List<Employee> findByLastname(@Param("last_name")String lastname);

    @Modifying
    @Transactional
    @Query("update EMPLOYEES set firstName=first_name, lastName=first_name where id=ID")
    Integer updateEmployeeName(@Param("first_name")String firstName,@Param("first_name") String lastName,@Param("ID") Long Id);
    //returns number of affected rows
}
