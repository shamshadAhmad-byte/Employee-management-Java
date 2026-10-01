package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.DepartmentResDto;
import com.example.demo.dto.EmployeeReqDto;
import com.example.demo.dto.EmployeeResDto;
import com.example.demo.dto.UpdateEmployeeReqDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public EmployeeResDto createEmployee(EmployeeReqDto employeeReqDtomployee) {
        Employee employee = createEmployeeFromDto(employeeReqDtomployee);

        if (existingEmployeewithEmail(employee.getEmail())) {
            throw new DuplicateException("Employee with email " + employee.getEmail() + " already exists.");
        }
        EmployeeResDto employeeResDto = createEmployeeToDto(employeeRepository.save(employee));
        return employeeResDto;
    }

    public EmployeeResDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Employee not found with id: " + id));
        return createEmployeeToDto(employee);
    }

    public List<EmployeeResDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResDto> employeeResDtos = employees.stream().map(this::createEmployeeToDto).toList();
        return employeeResDtos;
    }

    public EmployeeResDto updateEmployee(Long id, UpdateEmployeeReqDto employeeReqDto) {
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Employee not found with id: " + id));
        Employee employee = updateEmployeeFromDto(employeeReqDto, existingEmployee);
        EmployeeResDto employeeResDto = createEmployeeToDto(employeeRepository.save(employee));
        return employeeResDto;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(()
                -> new NotFoundException("Employee not found with id: " + id));
        employeeRepository.deleteById(id);
    }

    private Employee createEmployeeFromDto(EmployeeReqDto employeeReqDto) {
        Employee employee = new Employee();
        employee.setName(employeeReqDto.getName());
        employee.setEmail(employeeReqDto.getEmail());
        employee.setSalary(employeeReqDto.getSalary());
        employee.setPhoneNumber(employeeReqDto.getPhoneNumber());
        employee.setJobTitle(employeeReqDto.getJobTitle());
        employee.setStatus(employeeReqDto.getStatus());
        employee.setGender(employeeReqDto.getGender());
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        Department department = departmentRepository.findById(employeeReqDto.getDepartment().getId()).orElseThrow(()
                -> new NotFoundException("Department not found with id: " + employeeReqDto.getDepartment().getId()));
        employee.setDepartment(department);
        return employee;
    }

    private EmployeeResDto createEmployeeToDto(Employee employee) {
        EmployeeResDto employeeResDto = new EmployeeResDto();
        employeeResDto.setId(employee.getId());
        employeeResDto.setName(employee.getName());
        employeeResDto.setEmail(employee.getEmail());
        employeeResDto.setSalary(employee.getSalary());
        employeeResDto.setPhoneNumber(employee.getPhoneNumber());
        employeeResDto.setJobTitle(employee.getJobTitle());
        employeeResDto.setStatus(employee.getStatus());
        employeeResDto.setGender(employee.getGender());
        Department department = employee.getDepartment();
        DepartmentResDto departmentResDto= new DepartmentResDto();
        departmentResDto.setId(department.getId());
        departmentResDto.setName(department.getName());
        employeeResDto.setDepartment(departmentResDto);

        return employeeResDto;
    }

    private Employee updateEmployeeFromDto(UpdateEmployeeReqDto updateEmployeeReqDto, Employee employee) {
        employee.setName(updateEmployeeReqDto.getName());
        employee.setSalary(updateEmployeeReqDto.getSalary());
        employee.setPhoneNumber(updateEmployeeReqDto.getPhoneNumber());
        employee.setJobTitle(updateEmployeeReqDto.getJobTitle());
        employee.setStatus(updateEmployeeReqDto.getStatus());
        employee.setUpdatedAt(LocalDateTime.now());
        Department department = departmentRepository.findById(updateEmployeeReqDto.getDepartment().getId()).orElseThrow(()->
                new NotFoundException("Department not found with id: " + updateEmployeeReqDto.getDepartment().getId()));
        employee.setDepartment(department);
        return employee;
    }

    boolean existingEmployeewithEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }

}
