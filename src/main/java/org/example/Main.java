package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "Smith", 1000.0, LocalDate.of(1990, 10, 10)),
                new Employee(2, "Jan", "Nowak", 2000.0, LocalDate.of(1991, 11, 11)),
                new Employee(3, "Ela", "Belka", 3000.0, LocalDate.of(1992, 12, 12)),
                new Employee(4, "Michal", "Walka", 4000.0, LocalDate.of(1993, 1, 1)),
                new Employee(5, "Tomasz", "Tomkowicz", 5000.0, LocalDate.of(1994, 2, 2))
        );
        System.out.println("-----------------------Zad 1------------------------");
        Stream<Employee> streamofCollection = employees.stream().limit(3);
        streamofCollection.forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        Stream<Employee> streamBuilder = Stream.<Employee>builder().add(employees.get(1)).add(employees.get(3)).build();
        streamBuilder.forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        Stream<Employee> streamofArray = Arrays.stream(employees.toArray(Employee[]::new));
        streamofArray.forEach(System.out::println);

        System.out.println("--------------------------------------------------");

        Stream<List<Employee>> streamOf = Stream.of(employees);
        streamOf.forEach(System.out::println);
        System.out.println("-----------------------Zad 2--------------------------");
        Stream<Employee> concatstream = Stream.concat(employees.stream(), employees.stream());
        concatstream.forEach(System.out::println);

        System.out.println("----------------------Zad 3----------------------------");
        Stream<Employee> stream1 = employees.stream().limit(4);
        Stream<Employee> stream2 = Stream.<Employee>builder().add(employees.get(1)).add(employees.get(3)).build();
        Stream<Employee> stream3 = Stream.<Employee>builder().add(employees.get(0)).add(employees.get(4)).add(employees.get(2)).build();

        List<Employee> employeeList = stream1.toList();
        Set<Employee> employeeSet = stream2.collect(Collectors.toSet());
        Map<Long, Double> idSalaryMap = stream3.collect(Collectors.toMap(Employee::getId, Employee::getSalary));
        System.out.println("Mapa: " + idSalaryMap);


        System.out.println("----------------------Zad 4----------------------------");
        Stream<Object> stream4 = employees.stream().limit(4)
                .map(e -> e.getFirstname().toUpperCase());
                stream4.forEach(System.out::println);


        System.out.println("----------------------Zad 5-------------------------");

        employees.stream()
                .filter(e -> e.getFirstname().endsWith("a"))
                .forEach(System.out::println);
        System.out.println("----------------------Zad 6-------------------------");
        Stream<Employee> stream5 = employees.stream();
        stream5.sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);

        System.out.println("----------------------Zad 7-------------------------");
        List<Employee> stream6 = employees.stream().toList();
        Map<String,List<Employee>> map = stream6.stream()
                .collect(Collectors.groupingBy(Employee::getFirstname));

        map.forEach((firstName, employeeGroup) -> {
            System.out.println("Grupa pracowników o imieniu " + firstName + ":");
            employeeGroup.forEach(System.out::println);
            System.out.println();
        });

    }

}


class Employee {
    private Long id;
    private String firstname;
    private String surname;
    private Double salary;
    private LocalDate dateOfBirth;

    public Employee(Integer id, String firstname, String surname, Double salary, LocalDate dateOfBirth) {
        this.id = Long.valueOf(id);
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;

    }
    public Long getId() {
        return id;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public Double getSalary() {
        return salary;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", dateOfBirth=" + dateOfBirth +
                '}';

    }
}







