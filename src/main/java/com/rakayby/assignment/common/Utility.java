package com.rakayby.assignment.common;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.models.Employee;

/**
 *
 * @author Mohammed.Rakayby
 */
public class Utility {

    public static Boolean validateEmployee(Employee e) {
        return ((e.getFirstName() != null && !e.getFirstName().isEmpty() && e.getFirstName().length() > 2)
                && (e.getLastName() != null && !e.getLastName().isEmpty() && e.getLastName().length() > 2)
                && (e.getSalary() != null && e.getSalary() > 0)
                && (e.getPhoneNumber() != null && e.getPhoneNumber().matches("[0-9-]+")));
    }

    public static Boolean validateDepartment(Department d) {
        return ((d.getDepartmentName() != null && !d.getDepartmentName().isEmpty())
                && (d.getManagerId() != null && d.getManagerId() > 0));
    }
}
