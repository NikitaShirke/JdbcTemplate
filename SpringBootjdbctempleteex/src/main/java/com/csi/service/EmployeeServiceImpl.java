package com.csi.service;

import com.csi.dao.EmployeeDao;
import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDaoImpl;
    @Override
    public void save(Employee employee) {
       employeeDaoImpl.save(employee);
    }
    @Override
    public List<Employee> findAll() {
        return employeeDaoImpl.findAll();
    }
    @Override
    public void update(int empId, Employee employee) {
         employeeDaoImpl.update(empId,employee);
    }
    @Override
    public void deleteById(int empId) {
    employeeDaoImpl.deleteById(empId);
    }
}
