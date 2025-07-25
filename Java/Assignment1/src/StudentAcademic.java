import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentAcademic {

    String studentName;
    String[] subjects;
    int[] subjectMarks;
    String status="Pass";
    String grade=null;
    String standard;
    String stream;

    int obtainedMarks=0;
    float percentage=0.0f;
    public void setStudentDetails(){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter How Many Subjects do you have:");
        int totalSubjects=s.nextInt();
        s.nextLine();

        subjects=new String[totalSubjects];
        System.out.println("Enter your name: ");
        studentName=s.nextLine();
        if (!Pattern.matches("[A-za-z\s]+",studentName)) {
            System.out.println("Student name must not contains any special symbols and numbers");
            return;
        }
        System.out.println("which standard you are in:");
        standard=s.nextLine();
        System.out.println("which stream are you studied for:");
        stream=s.nextLine();





        System.out.println("Enter Subjects:");
        for (int i = 0; i < totalSubjects; i++) {
            subjects[i]=s.next();
        }
        subjectMarks=new int[totalSubjects];
        
        for (int i = 0; i < totalSubjects; i++) {
            System.out.println("Enter Marks of "+subjects[i]);

            if(subjectMarks[i]>=0 && subjectMarks[i]<=100){
                subjectMarks[i]=s.nextInt();
            }
            else{
                System.out.println("Invalid marks");
                return;
            }
        }
    }
    public void getStudentDetails(){
        int totalMarks=(subjects.length*100 );
        System.out.println("Name:"+studentName);

        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i]+" : "+subjectMarks[i]);
        }
        for (int i = 0; i < subjectMarks.length; i++) {
            obtainedMarks=obtainedMarks+subjectMarks[i];
        }
        percentage=((float) (obtainedMarks * 100) /totalMarks);
        System.out.println("Percentage:"+percentage+"%");
        if(percentage>80.00f){
            grade="Outstanding(O)";
        } else if (percentage>70.00f && percentage<79.00f) {
            grade="First Class with distinction(A)";
        }
        else if(percentage>60.00f && percentage<69.00f){
            grade="First Class(B)";
        } else if (percentage>50.00f && percentage<59.00f) {
            grade="Second class(C)";
        } else if (percentage>=35.00f && percentage<49.00f) {
            grade="Pass";
        }
        else {
            grade="Fail";
        }

    }

    public void saveReport(){
        try{
            String home=System.getProperty("user.home");
            String pathName=home+"/Documents/Student_Report.txt";
            File file=new File(pathName);
            if(file.createNewFile()){
                System.out.println("File is created");
            }
            else{
                System.out.println("File is not created or already created");
            }

            FileWriter fileWriter=new FileWriter(file,true);

            fileWriter.write("\nStudent Name:"+studentName+"\nClass:"+standard+"\nStream:"+stream);

            for(int i=0;i< subjects.length;i++){
                fileWriter.write(subjects[i]+" : "+subjectMarks[i]);

            }
            fileWriter.write("\nObtained Marks:"+obtainedMarks+"\nPercentage:"+percentage+"\n Grade:"+grade+"\nStatus:"+status);
            fileWriter.close();
            System.out.println("Report is saved");


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
