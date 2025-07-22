Employee Management System
This is a Java console-based application that helps manage and analyze employee information using Java collections and streams.

Features:
This application provides the following functionality:
   -Add a new employee. 
   -Display employees with a salary greater than 50,000.
   -Group employees by department.
   -Calculate average salary for each department.
   -Sort employees by experience and salary.
   -Exit the program.

Files
  -Main.java: Contains the main logic and user interaction loop.

  -Employee.java: Defines the Employee class and handles employee-related data input and representation.

Functionality Details
  -Add Employee
  -Prompts the user to enter employee ID, name, department, salary, and year of joining.
  -Calculates experience based on the current year.
  -Filter by Salary
  -Displays all employees whose salary is greater than 50,000.
  -Group by Department
  -Groups and displays employees based on their department.
  -Average Salary per Department
  -Calculates and displays the average salary of employees in each department.
  -Sort by Experience and Salary


How to Compile and Run
To compile:
  -javac Main.java Employee.java
To run:
  -java Main


Output:
1.Add Employee.
2.Get all the employees whose salary is greater than 50 thousand.
3.Group employees by department.
4.Average salary per department.
5.Sort employees by experience and salary.
6.EXIT
Enter your choice:
1
Enter employee id:
101
Enter employee name:
Amey
Enter department:
Engineering
Enter salary:
12000
Enter year of joining:
2025
Enter your choice:
1
Enter employee id:
102
Enter employee name:
Rishika
Enter department:
Management
Enter salary:
140000
Enter year of joining:
2017
Enter your choice:
2
EmpId:102 EmpName:Rishika EmpDept:Management EmpSalary:140000
Enter your choice:
3
Department:Engineering
EmpId:101 EmpName:Amey EmpDept:Engineering EmpSalary:12000
Department:Management
EmpId:102 EmpName:Rishika EmpDept:Management EmpSalary:140000
Enter your choice:
4
Department:Engineering Average salary:12000.0
Department:Management Average salary:140000.0
Enter your choice:
5
EmpId:101 EmpName:Amey EmpDept:Engineering EmpSalary:12000
EmpId:102 EmpName:Rishika EmpDept:Management EmpSalary:140000
Enter your choice:
6

Process finished with exit code 0
