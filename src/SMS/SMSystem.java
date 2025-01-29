package SMS;

import java.util.Scanner;

public class SMSystem {
    public Student student_start;
    public int studentSerialNumber=0;
    String studentAdmission(String name, String father, String mother, String course, String code){
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
    void display(){
        Student temp=student_start;
        while (temp!=null){
            System.out.println(temp.toString());
            temp=temp.next_student;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        //System storage for students
        SMSystem s=new SMSystem();

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
            String status=s.studentAdmission( name,father_name,mother_name,course_name,"BCS");
            System.out.println("Admission Status :: "+status);
            System.out.println("Want to add more student type :: Yes/No");
            add=sc.nextLine();
        }
        s.display();
    }
}
