import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1.Fill student details \n2.Display student details \n3.Save result to the report \n4.EXIT");

        StudentAcademic s=new StudentAcademic();
        while(true) {
            System.out.println("Enter your choice:");
            int choice=scanner.nextInt();
            switch (choice) {
                case 1:
                    s.setStudentDetails();
                    break;
                case 2:
                    s.getStudentDetails();
                    break;
                case 3:
                    s.saveReport();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid Choice!!!");
                    break;


            }
        }




    }
}