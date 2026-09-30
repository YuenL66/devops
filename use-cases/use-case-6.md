# USE CASE: 6 View an Employee's Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to view an employee's details so that the employee's promotion request can be supported.

### Scope
Company.

### Level
Primary task.

### Preconditions
* HR advisor is logged into the HR System.
* Employee records exist in the database.

### Success End Condition
The specified employee's details are successfully retrieved and displayed to the HR advisor.

### Failed End Condition
The employee details cannot be found, and an error message is displayed to the HR advisor.

### Primary Actor
HR advisor.

### Trigger
A request to look up an employee's profile is initiated.

## MAIN SUCCESS SCENARIO
1. HR advisor searches for the employee by name or ID.
2. HR system retrieves the employee's details from the database.
3. HR system displays the employee profile to the HR advisor.

## EXTENSIONS
* **2. ** *Employee does not exist*:
    1. HR system informs the HR advisor that the employee cannot be found.
* **2. ** *Database connection fails*:
    1. HR system informs the HR advisor that data cannot be retrieved.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0