package com.sap.testablecodekata.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Employee")
@Table(name = "Employee")
public class Employee {

    @Id
    private int id;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id", referencedColumnName = "Salaryid")
    private Salary salary;

    public Employee() {
    }

    public Employee(int id, Date dob, String address, Salary salary) {
        this.id = id;
        this.dob = dob;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
