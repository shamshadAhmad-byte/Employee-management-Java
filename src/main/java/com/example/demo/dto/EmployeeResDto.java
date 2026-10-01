package com.example.demo.dto;

public class EmployeeResDto {
    private Long id;
    private String name;
    private String email;
    private int salary;
    private String phoneNumber;
    private String jobTitle;
    private String status;
    private String gender;
    private DepartmentResDto department;
    public EmployeeResDto(){};
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
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
    public DepartmentResDto getDepartment(){
        return department;
    }
    public void setDepartment(DepartmentResDto department){
        this.department=department;
    }
}
