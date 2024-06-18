package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    String INSERT_SQL = "insert into employee(empId,empName,empAddress,empSalary,empContactNumber)values(?,?,?,?,?)";
    String SELECT_ALL_SQL = "select * from employee";
    String UPDATE_SQL = "update employee set empName=?,empAddress=?,empSalary=?,empContactNumber=? where empId=?";
    String DELETE_SQL_BY_ID = "delete from employee where empId=?";

    private Employee employee(ResultSet resultSet, int numRow) throws SQLException {
        return Employee.builder().empId(resultSet.getInt(1)).empName(resultSet.getString(2)).empAddress(resultSet.getString(3)).empSalary(resultSet.getDouble(4)).empContactNumber(resultSet.getLong(5)).build();
    }

    @Override
    public void save(Employee employee) {
        jdbcTemplate.update(INSERT_SQL, employee.getEmpId(), employee.getEmpName(), employee.getEmpAddress(), employee.getEmpSalary(), employee.getEmpContactNumber());
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL, this::employee);
    }

    @Override
    public void update(int empId, Employee employee) {
        jdbcTemplate.update(UPDATE_SQL, employee.getEmpName(), employee.getEmpAddress(),employee.getEmpSalary(), employee.getEmpContactNumber(), employee.getEmpId());
    }

    @Override
    public void deleteById(int empId) {
        jdbcTemplate.update(DELETE_SQL_BY_ID, empId);
    }
}
