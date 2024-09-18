package org.example.sample2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(23, 67, 84, 98, 100, 11, 68);
        System.out.println("Stream After applying the sorted() function: ");
        integers.stream().sorted().forEach(System.out::println);
        //natural order sorting ascending
        System.out.println("natural order sorting ascending");
        integers.stream().filter(i -> i < 50).sorted().forEach(System.out::println);
        //descending order sorting
        System.out.println("descending order sorting");
        integers.stream().filter(i -> i < 50).sorted((o1, o2) -> o2.compareTo(o1)).forEach(System.out::println);

        List<Employee> employeeList = Arrays.asList(new Employee("Sonit", 10), new Employee("Zonit", 2), new Employee("Anit", 12));
        List<Employee> sortedEmp = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        sortedEmp.forEach(System.out::println);
    }
}

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}