package com.napier.devops;

import com.napier.sem.Main;
import com.napier.sem.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    static Main app;

    @BeforeAll
    static void init() {
        app = new Main();
    }

    @Test
    void printSalariesTestNull() {
        app.printSalaries(null);
    }

    @Test
    void printSalariesTestEmpty() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        app.printSalaries(employees);
    }

    @Test
    void printSalariesTestContainsNull() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(null);
        app.printSalaries(employees);
    }

    @Test
    void printSalariesTestNormal() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.emp_no = 1;
        emp.first_name = "Kevin";
        emp.last_name = "Chalmers";
        emp.title = "Engineer";
        emp.salary = 55000;
        employees.add(emp);
        app.printSalaries(employees);
    }
}