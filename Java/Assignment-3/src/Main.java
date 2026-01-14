import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee employee;
        List<Employee> listOfEmployees=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Add Employee.\n2.Get all the employees whose salary is greater than 50 thousand.\n3.Group employees by department.\n4.Average salary per department.\n5.Sort employees by experience and salary.\n6.EXIT");
        while(true) {
            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    employee=new Employee();

                    listOfEmployees.add(employee);
                    break;
                case 2:
                    List<Employee> filteredBySalary=listOfEmployees.stream()
                          .filter(emp->emp.getSalary()>50000).toList();
                      filteredBySalary.forEach(System.out::println);
                      break;
                case 3:
                    Map<String,List<Employee>> groupByDepartment=listOfEmployees.stream()
                            .collect(Collectors.groupingBy(Employee::getEmpDept));
                    for(Map.Entry<String,List<Employee>> entry:groupByDepartment.entrySet()){
                        System.out.println("Department:"+entry.getKey());
                        entry.getValue().forEach(emp-> System.out.println(emp));
                    }
                    break;
                case 4:
                    Map<String,Double> averageSalaryByDepartment=listOfEmployees.stream()
                            .collect(Collectors.groupingBy(Employee::getEmpDept,Collectors.averagingDouble(Employee::getSalary)));
                    averageSalaryByDepartment.forEach((dept,avgsalary)-> System.out.println("Department:"+dept+" Average salary:"+avgsalary));
                    break;
                case 5:
                    List<Employee> sortedByExperienceAndsalary=listOfEmployees.stream()
                            .sorted(Comparator.comparing(Employee::getExperience).thenComparing(Employee::getSalary)).toList();
                    sortedByExperienceAndsalary.forEach(System.out::println);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice");
                    break;



            }
        }

//       Employee emp1=new Employee(1,"Amey","Engineering",12000);
//        Employee emp2=new Employee(2,"Kedar","Management",140000);
//        Employee emp3=new Employee(3,"Kaivalya","Engineering",70000);
//        List<Employee> li=new ArrayList<>();
//        li.add(emp1);
//        li.add(emp2);
//        li.add(emp3);
//        List<Employee> filteredWithNames= li.stream()
//                .filter(employee->employee.getEmpName().startsWith("A")).toList();
//
//        filteredWithNames.forEach(System.out::println);
//
//
//
//
//        List<Employee> sortByExperience
    }
}