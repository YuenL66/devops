# USE CASE: 3 Produce a Report on the Salary of Employees in a Department Manager's Department

## CHARACTERISTIC INFORMATION

### Goal in Context
As a department manager I want to produce a report on the salary of employees in my department so that I can support financial reporting for my department.

### Scope
Department.

### Level
Primary task.

### Preconditions
* Department manager is logged into the HR System.
* Manager's assigned department and employee salary data exist in the database.

### Success End Condition
A report listing all employees in the manager's specific department and their current salaries is successfully generated and presented.

### Failed End Condition
No report is produced, and an error message is displayed to the department manager.

### Primary Actor
Department manager.

### Trigger
A request for departmental financial reporting information is sent.

## MAIN SUCCESS SCENARIO
1. Department manager requests a salary report for their department.
2. HR system identifies the manager's department and retrieves employee details and current salaries filtered by that department from the database.
3. HR system formats the departmental salary data into a report.
4. HR system provides the report to the department manager.

## EXTENSIONS
* **2. ** *Database connection fails*:
    1. HR system informs the department manager that data cannot be retrieved.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0