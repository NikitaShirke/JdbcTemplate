package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String>saveData(@RequestBody Employee employee)
    {
        employeeServiceImpl.save(employee);
        return ResponseEntity.ok("Data Save Successfully");
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Employee>>findAll()
    {
        return ResponseEntity.ok(employeeServiceImpl.findAll());
    }
    @PutMapping("/updatedata/{empId}")

    public ResponseEntity<String>updateData(@PathVariable int empId,@RequestBody Employee employee)
    {
        employeeServiceImpl.update(empId,employee);
        return ResponseEntity.ok("Data Updated Successfully");
    }

    @DeleteMapping("/deletebyid/{empId}")
    public  ResponseEntity<String>deleteById(@PathVariable int empId)
    {
        employeeServiceImpl.deleteById(empId);
        return  ResponseEntity.ok("Data Deleted Successfully");
    }
}
