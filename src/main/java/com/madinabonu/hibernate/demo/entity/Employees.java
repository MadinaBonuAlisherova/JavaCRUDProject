package com.madinabonu.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employees {

    public Employees(String lastname, String firstname, String email, String department, int salary) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.department = department;
        this.salary = salary;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;

    @Column(name ="last_name")
    private String lastname;

    @Column(name ="first_name")
    private  String firstname;

    @Column(name ="email")
    private  String email;

    @Column(name ="department")
    private String department;

    @Column(name ="salary")
    private  int salary;

    //Constructor
    public Employees(){

    }

    @Override
    public String toString() {
        return "Student [id= "+id+", firstname= "+firstname+", lastname= "
                +lastname+", email= "+ email+", department= "+department+", salary= "+salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
