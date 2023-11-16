package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "Smith", 1000.0, LocalDate.of(1990, 10, 10)),
                new Employee(2, "Ivan", "Ivanov", 2000.0, LocalDate.of(1991, 11, 11)),
                new Employee(3, "Petr", "Petrov", 3000.0, LocalDate.of(1992, 12, 12)),
                new Employee(4, "Sidor", "Sidorov", 4000.0, LocalDate.of(1993, 1, 1)),
                new Employee(5, "Vasya", "Vasiliev", 5000.0, LocalDate.of(1994, 2, 2))
        );


        employees.stream()
                .filter(e -> e.getSalary() > 3000)
                .filter(e -> e.getFirstname().endsWith("a"))
                .forEach(System.out::println);
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







