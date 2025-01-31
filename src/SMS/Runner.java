package SMS;

import java.util.Scanner;
import SMS.SMSystem.*;
import SMS.utilities.*;
public class Runner {
    public static void main(String[] args){
        SMSystem activeStudents=SMSystem.getActiveStudents();
        //SMSystem deletedStudents=SMSystem.getDeletedStudents();
        /* Scanner class for tacking the user input*/
        Scanner sc= new Scanner(System.in);

        /*-----------------------------*/
        SMSystem.add(activeStudents, sc);
        activeStudents.displayStudents();

        /*-----------------------------*/

        // SMSystem.displayStudent(activeStudents.getStudentInformation(sc.nextLine()));
        // System.out.println("Deleting the added student");
        // SMSystem.studentAdmissionCancel("DCS1");
        // SMSystem.studentAdmissionCancel("DCS2");
        // System.out.println("----------------");
        // deletedStudents.displayStudents();
        utilities.updateName("DCS1","Bob", "active");
        activeStudents.displayStudents();

    }
}
