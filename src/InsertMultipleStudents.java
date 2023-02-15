import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertMultipleStudents {
    void insertMultiple(List<Student> studentList, int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Details of Students:\n");
            Student s2 = new Student();
            System.out.println("Enter Student RollNo:");
            s2.setRollNo(sc.nextInt());
            System.out.println("Enter Student Name:");
            s2.setName(sc.next());
            System.out.println("Enter Student Email:");
            s2.setEmail(sc.next());
            System.out.println("Enter Student Branch:");
            s2.setBranch(sc.next());
            System.out.println("Enter Student Year:");
            s2.setYear(sc.next());
            System.out.println("Enter Student CourseName:");
            s2.setCourseName(sc.next());
            studentList.add(s2);
            try {
                String url = "jdbc:mysql://localhost:3306/student-management-system";
                String user = "root";
                String pass = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, user, pass);
                Statement st = con.createStatement();
                st.executeUpdate("insert into student values('" + studentList.get(i).getRollNo() + "','"
                                                                    + studentList.get(i).getName() + "','"
                                                                    + studentList.get(i).getEmail() + "','"
                                                                    + studentList.get(i).getBranch() + "','"
                                                                    + studentList.get(i).getYear() + "','"
                                                                    + studentList.get(i).getCourseName() + "')");
            } catch (Exception e) {
                System.out.println(e);
            }


        }
    }
}



