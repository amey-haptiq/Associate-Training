
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
public class studentAcademic {

    public static void main(String[] args) {
        String grade=null;
        StringBuilder status= new StringBuilder("Pass");
        int totalMarks=300;

        String home = System.getProperty("user.home");
        String filePath=home + "/Documents/sample.txt";
        Scanner s=new Scanner(System.in);
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File is created");
            } else {
                System.out.println("file is already there");
            }


        System.out.println("1.Add Student data to file \n 2.Read and display Student data from file\n 3. Exit");

        while(true){
        System.out.println("Enter Your Choice:");
        int choice=s.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter Student name:");
                String studentName = s.next();
                System.out.println("Enter Physics marks:");
                int physicsMarks = s.nextInt();
                System.out.println("Enter chemistry marks:");
                int chemistryMarks = s.nextInt();
                System.out.println("Enter maths marks:");
                int mathsMarks = s.nextInt();
                if(mathsMarks>0 && mathsMarks<101 && physicsMarks>0 && physicsMarks<101 && chemistryMarks>0 && chemistryMarks<101) {
                    int obtainedMarks = physicsMarks + chemistryMarks + mathsMarks;
                    int percentage = ((obtainedMarks * 100) / totalMarks);
                    System.out.println("Name:" + studentName);
                    System.out.println("Obtained Marks:" + obtainedMarks);
                    System.out.println("Percentage:" + percentage);
                    if (percentage >= 80) {
                        grade = "O";


                    } else if (percentage >= 70 && percentage < 80) {
                        grade = "A";


                    } else if (percentage >= 60 && percentage <= 69) {
                        grade = "B";
                    } else if (percentage >= 50 && percentage <= 59) {
                        grade = "C";
                    } else if (percentage >= 40 && percentage <= 49) {
                        grade = "D";
                    } else if (percentage >= 35 && percentage <= 39) {
                        grade = "E";
                    } else if (percentage < 35) {
                        grade = "F";
                        status = new StringBuilder("Fail");
                    }

                    System.out.println("Grade:" + grade + " " + "Status:" + status.toString());
                    try {


                        FileWriter writer = new FileWriter(file, true);
                        writer.write("\nStudent Name:" + studentName + " Maths Marks:" + mathsMarks + " Physics Marks:" + physicsMarks + " Chemistry Marks:" + chemistryMarks + " Obtained Marks" + obtainedMarks + " Total Marks:" + totalMarks + "Percentage:" + percentage + " Grade:" + grade + " Status:" + status);
                        writer.close();
                        System.out.println("successfully added record to file");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else{
                    System.out.println("You trying to insert invalid marks/numbers.  Marks should be in the range of 0 to 100");
                    return;
                }

                break;
            case 2:
                try {
                    Scanner reader = new Scanner(file);
                    while (reader.hasNextLine()) {
                        String filedata = reader.nextLine();
                        
                        System.out.println(filedata);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Choice");
                break;
        }


     }
    } catch (Exception e) {
            System.out.println(e);
        }





    }
}
