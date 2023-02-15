import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student_Management_System {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        for(int j = 6 ;j>5;j++ ) {

            System.out.println("Enter the Command(insert_single/insert_multiple/select_single/select_multiple/update_single/update_multiple/delete_single/delete_multiple),Enter the 'stop' for exit the Application :");
            String command = sc.next();

            if (command.equals("insert_single")) {
                InsertSingleStudent insertStudent = new InsertSingleStudent();
                System.out.println("INSERT SINGLE:");
                insertStudent.insertStudent();
            }

            if (command.equals("insert_multiple")) {
                InsertMultipleStudents insertMultipleStudents = new InsertMultipleStudents();
                List<Student> studentList = new ArrayList<>();
                System.out.println("INSERT MULTIPLE:");
                System.out.println("Enter the number of Students:");
                int n = sc.nextInt();
                insertMultipleStudents.insertMultiple(studentList, n);
            }

            if (command.equals("select_single")) {
                SelectSingleStudent selectStudent = new SelectSingleStudent();
                System.out.println("SELECT SINGLE:");
                System.out.println("Enter the RollNo of Student:");
                selectStudent.selectStudent(sc.nextInt());
            }

            if (command.equals("select_multiple")) {
                SelectMultipleStudents selectMultipleStudents = new SelectMultipleStudents();
                List<Integer> rollNos = new ArrayList<>();
                System.out.println("SELECT MULTIPLE:");
                System.out.println("Enter the total number of Students:");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter the RollNos of Students:" + (i + 1));
                    rollNos.add(sc.nextInt());
                }
                selectMultipleStudents.selectMultipleStudents(rollNos);
            }

            if (command.equals("update_single")) {
                UpdateSingleStudent updateSingle = new UpdateSingleStudent();
                System.out.println("UPDATE SINGLE:");
                updateSingle.updateSingle();
            }

            if (command.equals("update_multiple")) {
                UpdateMultipleStudent updateMultipleStudent = new UpdateMultipleStudent();
                List<Integer> rollNos = new ArrayList<>();
                System.out.println("UPDATE MULTIPLE:");
                System.out.println("Enter the number of Students:");
                int n = sc.nextInt();
                updateMultipleStudent.updateMultipleStudent(rollNos, n);
            }

            if (command.equals("delete_single")) {
                DeleteSingleStudent deleteSingleStudent = new DeleteSingleStudent();
                System.out.println("DELETE SINGLE:");
                System.out.println("Enter the RollNo of Student which you want to delete:");
                int rollNo = sc.nextInt();
                deleteSingleStudent.deleteSingleStudent(rollNo);
            }

            if (command.equals("delete_multiple")) {
                DeleteMultipleStudents deleteMultipleStudents = new DeleteMultipleStudents();
                List<Integer> studentResult = new ArrayList<>();
                System.out.println("DELETE Multiple:");
                System.out.println("Enter the RollNo of Student How many you want to delete:");
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    System.out.println("Enter the RollNo of the Student:" + (i + 1));
                    studentResult.add(sc.nextInt());
                }
                deleteMultipleStudents.deleteMultipleStudent(studentResult);
            }

            if (command.equals("stop")) {
                System.out.println("Application has been stop:");
                break;
            }
        }
    }
}