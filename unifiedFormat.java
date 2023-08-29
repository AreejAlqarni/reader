/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class unifiedFormat{
    private String name;
    private int salary;
    private String department;
    private String gender;



    public unifiedFormat(String name, int salary, String department, String gender) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
    }
    public String getName() {
        return name;

    }

    public int getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
    public String getGender() {
        return gender;}


    @Override
    public String toString() {
        return "Name: " + name + ", salary: " + salary + ", depar: " + department +"gender: " + gender;
    }
}



