package com.example.demo.dto;

public class UpdateEmployeeReqDto {
    private String name;
    private int salary;
    private String phoneNumber;
    private String jobTitle;
    private String status;
    private DepartmentReqDto department;

    public UpdateEmployeeReqDto(){};

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
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
    public DepartmentReqDto getDepartment(){
        return department;
    }
    public void setDepartment(DepartmentReqDto department){
        this.department=department;
    }
}
