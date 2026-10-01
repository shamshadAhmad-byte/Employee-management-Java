package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.exception.DuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.DepartmentRepository;

@Service 
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }
    public Department createDepartment(Department department){
        if(existByName(department.getName())){
            throw new DuplicateException("Department already exists with name: " + department.getName());
        }
        return departmentRepository.save(department);
    }
    public Department getDepartment(Long id){
        return departmentRepository.findById(id).orElseThrow(()-> 
        new NotFoundException("Department not found with id: " + id));
    }
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public void deleteDepartment(Long id){
        departmentRepository.findById(id)
        .orElseThrow(()-> new NotFoundException("Department not found with id: " + id));
        departmentRepository.deleteById(id);
    }

    private boolean existByName(String name){
        return departmentRepository.existsByName(name);
    }
}
