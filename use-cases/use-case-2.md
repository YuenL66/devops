# USE CASE: 2 Produce a Report on the Salary of Employees in a Department

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to produce a report on the salary of employees in a department so that I can support financial reporting of the organisation.

### Scope
Company.

### Level
Primary task.

### Preconditions
* HR advisor is logged into the HR System.
* Department and employee salary data exist in the database.

### Success End Condition
A report listing all employees in the specified department and their current salaries is successfully generated and presented to the HR advisor.

### Failed End Condition
No report is produced, and an error message is displayed to the HR advisor.

### Primary Actor
HR advisor.

### Trigger
A request for departmental financial reporting information is sent.

## MAIN SUCCESS SCENARIO
1. HR advisor requests a salary report for a specific department.
2. HR system retrieves employee details and current salaries filtered by the department from the database.
3. HR system formats the departmental salary data into a report.
4. HR system provides the report to the HR advisor.

## EXTENSIONS
* **2. ** *Department does not exist*:
    1. HR system informs the HR advisor that the department cannot be found.
* **2. ** *Database connection fails*:
    1. HR system informs the HR advisor that data cannot be retrieved.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0