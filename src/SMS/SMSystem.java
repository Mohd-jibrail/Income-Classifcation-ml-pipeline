package SMS;

import java.util.Scanner;

import LinkedList.Node;
import SMS.Student;
public class SMSystem {
    public Student student_start;
    public static int studentSerialNumber=0;
    private SMSystem(){}
    private static SMSystem activeStudents;
    private static SMSystem deletedStudents;
    public static SMSystem getActiveStudentsList(){
        activeStudents= new SMSystem();
        return activeStudents;
    }
    public static SMSystem getDeletedStudents(){
        deletedStudents=new SMSystem();
        return deletedStudents;
    }
    public String studentAdmission(String name, String father, String mother, String course, String code){
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
    public Student getStudentInformation(String roll_number){
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
    public void displayStudents(){
        Student temp=student_start;
        while (temp!=null){
            System.out.println(temp.toString());
            temp=temp.next_student;
        }
        System.out.println("null");
    }
    public static void displayStudent(Student student) {
        String st=null;
        if(student!=null){
            st= "Student  {" +
                    "name='" + student.getName() + '\'' +
                    ", father_name='" + student.getFather_name()+ '\'' +
                    ", mother_name='" + student.getMother_name() + '\'' +
                    ", roll_number='" + student.getRoll_number() + '\'' +
                    ", course_name='" + student.getCourse_name() + '\'' +
                    ", course_code='" + student.getCourse_code() + "}";
        }
        System.out.println(st);
    }
    public static void add(SMSystem smSystem, Scanner sc){
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
    }
    public static String studentAdmissionCancel(String roll_number){

        Student temp_student=activeStudents.student_start;
        Student prev_student=null;
        if(temp_student!=null && temp_student.getRoll_number().equalsIgnoreCase(roll_number)){
            activeStudents.student_start=temp_student.next_student;
            return "Admission Cancelled";
        }
        while (temp_student!= null && temp_student.next_student!=null){
            if(temp_student.getRoll_number().equalsIgnoreCase(roll_number)){
                deletedStudents.studentAdmission(temp_student.getName(),temp_student.getFather_name(),temp_student.getMother_name(),temp_student.getCourse_name(),temp_student.getCourse_code());
                prev_student.next_student=temp_student.next_student;
                studentSerialNumber--;

            }
            prev_student =temp_student;
            temp_student=temp_student.next_student;
        }
        return "No Student Found";
    }
}
