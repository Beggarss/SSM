package com.hrms.model;

public class EmployeeSalary {
    private String empPositiom;

    private Integer salary;

    public String getEmpPositiom() {
        return empPositiom;
    }

    public void setEmpPositiom(String empPositiom) {
        this.empPositiom = empPositiom == null ? null : empPositiom.trim();
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}