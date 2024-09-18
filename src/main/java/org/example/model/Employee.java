package org.example.model;

public class Employee {

  private final String name;
  private final int age;
  private final String department;
  private final int Salary;

  public Employee(String name, int age, String department, int salary) {
    this.name = name;
    this.age = age;
    this.department = department;
    Salary = salary;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getDepartment() {
    return department;
  }

  public int getSalary() {
    return Salary;
  }

  @Override
  public String toString() {
    return "Employee{"
        + "name='"
        + name
        + '\''
        + ", age="
        + age
        + ", department='"
        + department
        + '\''
        + ", Salary="
        + Salary
        + '}';
  }
}
