package com.employeemanager.controller;

import com.employeemanager.dto.EmployeeDTO;
import com.employeemanager.entity.EmployeeEntity;
import com.employeemanager.service.EmployeeManagerService;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmployeeManagerController {
    @Autowired
    private EmployeeManagerService employeeManagerService;

    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeManagerService.createEmployee(employeeDTO);
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeManagerService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Optional<EmployeeEntity> getEmployeesByID(@PathVariable (value = "id") Long employeeId) {
        return employeeManagerService.getEmployeesByID(employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Object> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        return employeeManagerService.deleteEmployee(employeeId);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "id") Long employeeId, @RequestBody EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        return employeeManagerService.updateEmployee(employeeId, employeeDTO);
    }

}
