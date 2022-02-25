package com.sapient.web.model;

public class EmployeeModel {
    private String name;
    private String department;
    private double salary;
    private String address;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String name, String department, double salary, String address) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "EmployeeModel{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
