package com.isioma.week9task4.service;

import com.isioma.week9task4.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee saveEmployee (Employee employee);

    Employee getEmployeeById (Long id);

    Employee updateEmployee (Employee employee);

    void deleteEmployeeById (Long id);

}
