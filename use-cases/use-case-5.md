# USE CASE: 5 Add a New Employee's Details

## CHARACTERISTIC INFORMATION

### Goal in Context
As an HR advisor I want to add a new employee's details so that I can ensure the new employee is paid.

### Scope
Company.

### Level
Primary task.

### Preconditions
* HR advisor is logged into the HR System.
* Employee details (name, birth date, gender, hire date, etc.) are available.

### Success End Condition
The new employee's details are successfully recorded in the database, allowing payroll processing.

### Failed End Condition
The new employee's details are not saved, and an error message is displayed to the HR advisor.

### Primary Actor
HR advisor.

### Trigger
A request to register a new employee is initiated.

## MAIN SUCCESS SCENARIO
1. HR advisor enters the new employee's details into the HR system.
2. HR system validates the provided details.
3. HR system saves the new employee record to the database.
4. HR system confirms successful creation to the HR advisor.

## EXTENSIONS
* **2. ** *Invalid data entered*:
    1. HR system informs the HR advisor of the validation error and prompts for correction.
* **3. ** *Database connection fails*:
    1. HR system informs the HR advisor that the record could not be saved.

## SUB-VARIATIONS
None.

## SCHEDULE
**DUE DATE:** Release 1.0