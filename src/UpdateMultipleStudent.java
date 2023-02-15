import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateMultipleStudent {
    void updateMultipleStudent(List<Integer> rollNos,int n) {
        SelectMultipleStudents ss1 = new SelectMultipleStudents();
        Scanner sc = new Scanner(System.in);
        Student s5 = new Student();
        for (int i = 0; i <n; i++){
            System.out.println("Update the details of Students:"+(i+1));
            System.out.println("Enter the RollNo of Student:"+(i+1));
            s5.setRollNo(sc.nextInt());
            System.out.println("Enter the Name of Student:"+(i+1));
            s5.setName(sc.next());
            System.out.println("Enter the Email of Student:"+(i+1));
            s5.setEmail(sc.next());
            System.out.println("Enter the Branch of Student:"+(i+1));
            s5.setBranch(sc.next());
            System.out.println("Enter the Year of Student:"+(i+1));
            s5.setYear(sc.next());
            System.out.println("Enter the Course_Name of Student:"+(i+1));
            s5.setCourseName(sc.next());
            System.out.println("\n");
            try {
                String url = "jdbc:mysql://localhost:3306/student-management-system";
                String user = "root";
                String pass = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();


                st.executeUpdate("update student set name='" + s5.getName()
                                                   + "',email='" + s5.getEmail()
                                                   + "',branch='" + s5.getBranch()
                                                   + "',year='" + s5.getYear()
                                                   + "',courseName='" + s5.getCourseName()
                                                   + "' where rollNo='" + s5.getRollNo() + "'");
                rollNos.add(s5.getRollNo());

            } catch (Exception e) {
                System.out.println(e);
            }
            ss1.selectMultipleStudents(rollNos);
        }
        }
}

