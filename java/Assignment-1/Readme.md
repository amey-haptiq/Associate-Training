This is the application guide for StudentAcademic  grade calculator.
This application consists two classes which are as follows:
   1.StudentAcademic class:  StudentAcademic class is responsible for accepting student data,display the student record on the command line and save data to the "Student_Report.txt" file.
                             This class consists three methods:
                                 i)setStudentDetails():This method is responsible for accepting the input from the user.
                                                       It takes inputs such as student name,standard,stream,total subjects,subject names,subject wise marks from the user.
                                 ii)getStudentDetails():This method is responsible for calculating grade and status and display the details on command line.
                                 iii)saveReport():This method is responsible for creating file(if not created already) and save the details to the "Student_report.txt" file
   2.Main():  This is the driver class responsible for run the application.




Application's I/O:
1.Fill student details
2.Display student details
3.Save result to the report
4.EXIT
Enter your choice:
1
Enter How Many Subjects do you have:
3
Enter your name:
Amey kulkarni
which standard you are in:
12th class
which stream are you studied for:
Science
Enter Subjects:
Physics
Chemistry
Maths
Enter Marks of Physics
78
Enter Marks of Chemistry
67
Enter Marks of aths
88
Enter your choice:
2
Name:Amey kulkarni
Physics : 78
Chemistry : 67
aths : 88
Percentage:77.666664%
Enter your choice:
3
File is not created
Report is saved
Enter your choice:
4

Process finished with exit code 0
