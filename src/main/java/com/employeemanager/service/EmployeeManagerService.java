package com.employeemanager.service;


import com.employeemanager.dto.EmployeeDTO;
import com.employeemanager.entity.EmployeeEntity;
import com.employeemanager.repository.EmployeeRepository;
import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeManagerService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeEntity createEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity newEmployee = EmployeeEntity.builder()
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .email(employeeDTO.getEmail())
                .role(employeeDTO.getRole())
                .location(employeeDTO.getLocation())
                .dateStarted(employeeDTO.getDateStarted())
                .manager(employeeDTO.getManager())
                .build();
        return employeeRepository.save(newEmployee);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> getEmployeesByID(Long id) {
        return employeeRepository.findById(id);
    }

    public Map<String, Object> deleteEmployee(Long employeeId)
            throws ResourceNotFoundException {
        EmployeeEntity employeeToDelete = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employeeToDelete);
        Map<String, Object> response = new HashMap<>();
        response.put("Deleted", employeeToDelete.getFirstName() + " " + employeeToDelete.getLastName());
        response.put("OK", Boolean.TRUE);
        return response;
    }

    public ResponseEntity<EmployeeEntity> updateEmployee(Long employeeId, EmployeeDTO employeeDTO) throws ResourceNotFoundException {
        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        existingEmployee.setFirstName(employeeDTO.getFirstName());
        existingEmployee.setLastName(employeeDTO.getLastName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setRole(employeeDTO.getRole());
        existingEmployee.setLocation(employeeDTO.getLocation());
        existingEmployee.setDateStarted(employeeDTO.getDateStarted());
        existingEmployee.setManager(employeeDTO.getManager());
        final EmployeeEntity updatedEmployee = employeeRepository.save(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }
}
