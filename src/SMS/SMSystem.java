package SMS;

import java.util.Scanner;
import SMS.Student;
public class SMSystem {
    public Student student_start;
    public int studentSerialNumber=0;
    private String studentAdmission(String name, String father, String mother, String course, String code){
        Student newStudent= new Student(name, father,mother,course,code);
        if (student_start==null){
            student_start=newStudent;
            studentSerialNumber++;
            return " First Student Added";
        }else {
            Student temp_student=student_start;
            while (temp_student.next_student!=null){
                temp_student=temp_student.next_student;
            }
            temp_student.next_student=newStudent;
            studentSerialNumber++;
        }
        return "Student Added";
    }

    private Student getStudentInformation(String roll_number){
        Student current_student=student_start;
        if(current_student.getRoll_number().equalsIgnoreCase(roll_number)){
            return current_student;
        }
        while (current_student!=null && current_student.next_student!=null){
            if(current_student.getRoll_number().equalsIgnoreCase(roll_number)){
                return current_student;
            }else {
                current_student=current_student.next_student;
            }
        }
        return null;
    }
    private void display(){
        Student temp=student_start;
        while (temp!=null){
            System.out.println(temp.toString());
            temp=temp.next_student;
        }
        System.out.println("null");
    }
    public static String toStringStudent(Student student) {
        return "Student{" +
                "name='" + student.getName() + '\'' +
                ", father_name='" + student.getFather_name()+ '\'' +
                ", mother_name='" + student.getMother_name() + '\'' +
                ", roll_number='" + student.getRoll_number() + '\'' +
                ", course_name='" + student.getCourse_name() + '\'' +
                ", course_code='" + student.getCourse_code() + "}";
    }
    public static void main(String[] args){
        //System storage for students
        SMSystem smSystem=new SMSystem();

        Scanner sc= new Scanner(System.in);
        String add= "yes";
        while (add.equalsIgnoreCase("yes")){
            System.out.print("Student Name :: ");
            String name =sc.nextLine();
            System.out.print("Father Name :: ");
            String father_name =sc.nextLine();
            System.out.print("Mother Name :: ");
            String mother_name =sc.nextLine();
            System.out.print("Course Name :: ");
            String course_name = sc.nextLine();
            String status=smSystem.studentAdmission( name,father_name,mother_name,course_name,"BCS");
            System.out.println("Admission Status :: "+status);
            System.out.println("Want to add more student type :: Yes/No");
            add=sc.nextLine();
        }
        smSystem.display();
        System.out.println("Enter student roll number ::: ");
        String roll_number =sc.nextLine();
        Student student=smSystem.getStudentInformation(roll_number);
        if(student!=null){
            System.out.println(toStringStudent(student));
        }
    }
}
