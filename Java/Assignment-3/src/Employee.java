import java.time.LocalDate;
import java.util.Scanner;

public class Employee {
    int empId;
    String empName;
    String empDept;
    long salary;
    int experience;
    int yearOfJoining;
    public Employee(){
        Scanner s=new Scanner(System.in);
        LocalDate today=LocalDate.now();
       int year= today.getYear();
        System.out.println("Enter employee id:");
        this.empId=s.nextInt();
        s.nextLine();
        System.out.println("Enter employee name:");
        this.empName=s.nextLine();
        System.out.println("Enter department:");
        this.empDept=s.nextLine();
        System.out.println("Enter salary:");
        this.salary=s.nextLong();
        System.out.println("Enter year of joining:");
        this.yearOfJoining=s.nextInt();
        this.experience=year-this.yearOfJoining;

    }
    public Employee(int empId,String empName,String empDept,long salary,int dateOfJoining){
//        this.empId=empId;
//        this.empName=empName;
//        this.empDept=empDept;
//        this.salary=salary;
//
//        this.experience=year-this.dateOfJoining


    }

    public int getExperience() {
        return experience;
    }

    public int getEmpId() {
        return empId;
    }
    public String getEmpName(){
        return empName;
    }
    public String getEmpDept(){
        return empDept;
    }

    public long getSalary() {
        return salary;
    }
    public String toString(){
        return "EmpId:"+empId+" EmpName:"+empName+" EmpDept:"+empDept+" EmpSalary:"+salary;
    }
}
