package com.rakayby.assignment.common;

import com.rakayby.assignment.models.Department;
import com.rakayby.assignment.models.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Mohammed.Rakayby
 */
public class Utility {

    private static final Logger debugLogger = LogManager.getLogger("DEBUG");
    private static final Logger errorLogger = LogManager.getLogger("ERROR");

    public static Boolean validateEmployee(Employee e) {
        debugLogger.debug("@validateEmployee, validating employee with ID: {}", e.getId());
        return ((e.getFirstName() != null && !e.getFirstName().isEmpty() && e.getFirstName().length() > 2)
                && (e.getLastName() != null && !e.getLastName().isEmpty() && e.getLastName().length() > 2)
                && (e.getSalary() != null && e.getSalary() > 0)
                && (e.getPhoneNumber() != null && e.getPhoneNumber().matches("[0-9-]+")));
    }

    public static Boolean validateDepartment(Department d) {
        debugLogger.debug("@validateDepartment, validating department with ID: {}", d.getId());
        return ((d.getDepartmentName() != null && !d.getDepartmentName().isEmpty())
                && (d.getManagerId() != null && d.getManagerId() > 0));
    }
}
