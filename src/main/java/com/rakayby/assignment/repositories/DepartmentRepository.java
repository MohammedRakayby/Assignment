/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rakayby.assignment.repositories;

import com.rakayby.assignment.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mohammed.Rakayby
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    //nothing needed more than CRUD therefore, will use spring implementation only.
    //so this interface will not include any new methods in my case.
    //however, more business logic could be added here if needed.
}
