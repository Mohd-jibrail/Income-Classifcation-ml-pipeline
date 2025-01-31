package SMS;

import SMS.SMSystem;
import SMS.Student;
public class utilities {
    public static void updateName(String rollNumber, String name, String studentType){
        Student student_start;
        if(studentType.equalsIgnoreCase("active")){
            student_start=SMSystem.getActiveStudents().student_start;
        }else {
            student_start=SMSystem.getDeletedStudents().student_start;
        }
        if(student_start != null && student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
            student_start.setName(name);
            System.out.println("Updated");
        }else {
            while (student_start!= null && !student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
                student_start=student_start.next_student;
            }
            if(student_start==null){
                System.out.println("No Student found");
                return;
            }
            student_start.setName(name);
        }
    }
    public static void updateFatherName(String rollNumber, String father_name, String studentType){
        Student student_start;
        if(studentType.equalsIgnoreCase("active")){
            student_start=SMSystem.getActiveStudents().student_start;
        }else {
            student_start=SMSystem.getDeletedStudents().student_start;
        }
        if(student_start != null && student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
            student_start.setFather_name(father_name);
            System.out.println("Updated");
        }else {
            while (student_start!= null && !student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
                student_start=student_start.next_student;
            }
            if(student_start==null){
                System.out.println("No Student found");
                return;
            }
            student_start.setFather_name(father_name);
        }
    }
    public static void updateMotherName(String rollNumber, String mother_name, String studentType){
        Student student_start;
        if(studentType.equalsIgnoreCase("active")){
            student_start=SMSystem.getActiveStudents().student_start;
        }else {
            student_start=SMSystem.getDeletedStudents().student_start;
        }
        if(student_start != null && student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
            student_start.setMother_name(mother_name);
            System.out.println("Updated");
        }else {
            while (student_start!= null && !student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
                student_start=student_start.next_student;
            }
            if(student_start==null){
                System.out.println("No Student found");
                return;
            }
            student_start.setMother_name(mother_name);
        }
    }
    public static void updateCourseName(String rollNumber, String course_name, String studentType){
        Student student_start;
        if(studentType.equalsIgnoreCase("active")){
            student_start=SMSystem.getActiveStudents().student_start;
        }else {
            student_start=SMSystem.getDeletedStudents().student_start;
        }
        if(student_start != null && student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
            student_start.setCourse_name(course_name);
            System.out.println("Updated");
        }else {
            while (student_start!= null && !student_start.getRoll_number().equalsIgnoreCase(rollNumber)){
                student_start=student_start.next_student;
            }
            if(student_start==null){
                System.out.println("No Student found");
                return;
            }
            student_start.setCourse_name(course_name);
        }
    }
}
