package com.csi.dao;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeDao {

    void save(Employee employee);

    List<Employee> findAll();

    void update(int empId, Employee employee);

    void deleteById(int empId);


}
