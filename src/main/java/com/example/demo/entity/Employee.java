package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity 
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message ="Name is required")
    @Size(min=2, max=50, message="Name must be between 2 and 50 characters")
    private String name;
    
    @NotBlank(message ="Email is required")
    @Email(message="Email should be valid")
    private String email;

    @Min(value=10000, message="Salary must be a positive number")
    private int salary;
    @NotBlank (message ="Phone number is required")
    @Pattern(regexp = "^[6-9][0-9]{9}$",
        message = "Enter a valid 10-digit phone number")
    private String phoneNumber;
    @NotBlank (message ="Job title is required")
    private String jobTitle;
    @NotBlank(message ="Status is required")
    private String status;
    @NotBlank(message ="Gender is required")
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne 
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    public Employee(){};

    public Long getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public int getSalary(){
        return salary;
    }
    public void setSalary(int salary){
        this.salary=salary;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public String getJobTitle(){
        return jobTitle;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle=jobTitle;
    }

    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt=updatedAt;
    }
    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }

}