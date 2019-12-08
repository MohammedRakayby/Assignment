package com.rakayby.assignment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mohammed.Rakayby
 */
@Entity(name = "DEPARTMENTS")
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
    
    @Column(name = "MANAGER_ID")
    private Long managerId;
}
