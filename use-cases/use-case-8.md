# USE CASE: 8 Delete an Employee's Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to delete an employee's details so that the company is compliant with data retention legislation.

### Scope
Company.

### Level
Primary task.

### Preconditions
* HR advisor is logged into the HR System.
* The employee record already exists in the database.

### Success End Condition
The specified employee's details are successfully removed from the database to comply with data retention rules.

### Failed End Condition
The employee record is not deleted, and an error message is displayed to the HR advisor.

### Primary Actor
HR advisor.

### Trigger
A request to delete an existing employee's record is initiated.

## MAIN SUCCESS SCENARIO
1. HR advisor searches for and selects the employee to delete.
2. HR advisor confirms the deletion request.
3. HR system removes the employee record from the database.
4. HR system confirms successful deletion to the HR advisor.

## EXTENSIONS
* **1. ** *Employee does not exist*:
    1. HR system informs the HR advisor that the employee cannot be found.
* **3. ** *Database connection fails*:
    1. HR system informs the HR advisor that the record could not be deleted.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0