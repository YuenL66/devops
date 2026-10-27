package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class Main
{
    private Connection con = null;

    /**
     * Connect to the MySQL database with location and delay parameters.
     */
    public void connect(String location, int delay)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                Thread.sleep(delay);
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/employees?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args)
    {
        Main a = new Main();

        if (args.length < 1)
        {
            a.connect("localhost:33060", 30000);
        }
        else
        {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        ArrayList<Employee> employees = a.getAllSalaries();
        a.printSalaries(employees);
        a.disconnect();
    }

    public ArrayList<Employee> getAllSalaries()
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT employees.emp_no, employees.first_name, employees.last_name, salaries.salary " +
                            "FROM employees, salaries " +
                            "WHERE employees.emp_no = salaries.emp_no AND salaries.to_date = '9999-01-01' " +
                            "ORDER BY employees.emp_no ASC";
            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Employee> employees = new ArrayList<Employee>();
            while (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("employees.emp_no");
                emp.first_name = rset.getString("employees.first_name");
                emp.last_name = rset.getString("employees.last_name");
                emp.salary = rset.getInt("salaries.salary");
                employees.add(emp);
            }
            return employees;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }

    public void printSalaries(ArrayList<Employee> employees)
    {
        if (employees == null)
        {
            System.out.println("No employees");
            return;
        }
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "Emp No", "First Name", "Last Name", "Salary"));
        for (Employee emp : employees)
        {
            if (emp == null) continue;
            String emp_string = String.format("%-10s %-15s %-20s %-8s", emp.emp_no, emp.first_name, emp.last_name, emp.salary);
            System.out.println(emp_string);
        }
    }

    public Employee getEmployee(int ID)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strSelect =
                    "SELECT e.emp_no, e.first_name, e.last_name, "
                            + "t.title, s.salary, d.dept_name, "
                            + "m.first_name AS mgr_first, m.last_name AS mgr_last "
                            + "FROM employees e "
                            + "JOIN titles t ON e.emp_no = t.emp_no "
                            + "JOIN salaries s ON e.emp_no = s.emp_no "
                            + "JOIN dept_emp de ON e.emp_no = de.emp_no "
                            + "JOIN departments d ON de.dept_no = d.dept_no "
                            + "JOIN dept_manager dm ON de.dept_no = dm.dept_no "
                            + "JOIN employees m ON dm.emp_no = m.emp_no "
                            + "WHERE e.emp_no = " + ID
                            + " AND t.to_date = '9999-01-01'"
                            + " AND s.to_date = '9999-01-01'"
                            + " AND de.to_date = '9999-01-01'"
                            + " AND dm.to_date = '9999-01-01'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next())
            {
                Employee emp = new Employee();
                emp.emp_no = rset.getInt("emp_no");
                emp.first_name = rset.getString("first_name");
                emp.last_name = rset.getString("last_name");
                emp.title = rset.getString("title");
                emp.salary = rset.getInt("salary");
                emp.dept_name = rset.getString("dept_name");
                emp.manager = rset.getString("mgr_first") + " " + rset.getString("mgr_last");
                return emp;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get employee details");
            return null;
        }
    }

    public void addEmployee(Employee emp)
    {
        try
        {
            Statement stmt = con.createStatement();
            String strUpdate = "INSERT INTO employees (emp_no, first_name, last_name, birth_date, gender, hire_date) " +
                    "VALUES (" + emp.emp_no + ", '" + emp.first_name + "', '" + emp.last_name + "', " +
                    "'9999-01-01', 'M', '9999-01-01')";
            stmt.execute(strUpdate);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to add employee");
        }
    }
}