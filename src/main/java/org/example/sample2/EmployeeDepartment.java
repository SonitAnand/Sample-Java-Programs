package org.example.sample2;

import com.solution.model.Employee;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeDepartment {

  public static void main(String[] args) {
    List<Employee> employees =
        List.of(
            new Employee("Sonit1", 30, "IT", 20000),
            new Employee("Sonit2", 35, "CS", 40000),
            new Employee("Sonit3", 20, "CS", 15000),
            new Employee("Sonit4", 25, "ECE", 30000),
            new Employee("Sonit5", 19, "IT", 5000));

    Map<String, Long> departmentWiseEmployeeCount =
        employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    System.out.println("Department Wise Employee Count:" + departmentWiseEmployeeCount);

    Map<String, Optional<Employee>> highestSalaryFromEachDepartment =
        employees.stream()
            .collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
    System.out.println("Highest Salary From Each Department:" + highestSalaryFromEachDepartment);

    String highestSalaryEmployeeName =
        employees.stream()
            .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
            .findFirst()
            .get()
            .getName();
    System.out.println("Highest Salary Employee Name:" + highestSalaryEmployeeName);
  }
}
