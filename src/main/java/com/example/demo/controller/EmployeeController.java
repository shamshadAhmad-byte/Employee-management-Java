package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeReqDto;
import com.example.demo.dto.EmployeeResDto;
import com.example.demo.dto.UpdateEmployeeReqDto;
import com.example.demo.service.EmployeeService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @PostMapping
    public ResponseEntity<EmployeeResDto> createEmployee(@Valid @RequestBody EmployeeReqDto employeeReqDto) {
        return ResponseEntity.status(201).body(employeeService.createEmployee(employeeReqDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResDto> getEmployee(@PathVariable Long id) {
        EmployeeResDto employeeResDto= employeeService.getEmployee(id);
        return ResponseEntity.status(200).body(employeeResDto);
    }
    
    @GetMapping
    public ResponseEntity<List<EmployeeResDto>> getAllEmployee() {
        return ResponseEntity.status(200).body(employeeService.getAllEmployee());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResDto> updateEmployee(@PathVariable Long id,@Valid @RequestBody UpdateEmployeeReqDto updateEmployeeReqDto){
        EmployeeResDto employeeResDto = employeeService.updateEmployee(id, updateEmployeeReqDto);
        return ResponseEntity.status(200).body(employeeResDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
            employeeService.deleteEmployee(id);
            return ResponseEntity.status(200).body("employee deleted successfully");
    }
}
