# USE CASE: 7 Update an Employee's Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to update an employee's details so that employee's details are kept up-to-date.

### Scope
Company.

### Level
Primary task.

### Preconditions
* HR advisor is logged into the HR System.
* The employee record already exists in the database.

### Success End Condition
The specified employee's details are successfully updated in the database.

### Failed End Condition
The employee's details are not updated, and an error message is displayed to the HR advisor.

### Primary Actor
HR advisor.

### Trigger
A request to update an existing employee's details is initiated.

## MAIN SUCCESS SCENARIO
1. HR advisor searches for and selects the employee to update.
2. HR advisor modifies the necessary details (e.g., address, name, department).
3. HR system validates the updated information.
4. HR system saves the updated record to the database.
5. HR system confirms successful update to the HR advisor.

## EXTENSIONS
* **1. ** *Employee does not exist*:
    1. HR system informs the HR advisor that the employee cannot be found.
* **3. ** *Invalid data entered*:
    1. HR system informs the HR advisor of the validation error and prompts for correction.
* **4. ** *Database connection fails*:
    1. HR system informs the HR advisor that the update could not be saved.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0