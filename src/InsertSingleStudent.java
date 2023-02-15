import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
public class InsertSingleStudent {
    void  insertStudent(){
        Student s1=new Student();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Details of Single Student:\n");
        System.out.println("Enter the RollNo of Student:");
        s1.setRollNo(sc.nextInt());
        System.out.println("Enter the Name of Student:");
        s1.setName(sc.next());
        System.out.println("Enter the Email of Student:");
        s1.setEmail(sc.next());
        System.out.println("Enter the Branch of Student:");
        s1.setBranch(sc.next());
        System.out.println("Enter the Year of Student:");
        s1.setYear(sc.next());
        System.out.println("Enter the Course_Name of Student:");
        s1.setCourseName(sc.next());
        try{
            String url="jdbc:mysql://localhost:3306/student-management-system";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            st.executeUpdate("insert into student values('"+s1.getRollNo()+"','"
                                                               +s1.getName()+"','"
                                                               +s1.getEmail() +"','"
                                                               +s1.getBranch()+"','"
                                                               +s1.getYear()+"','"
                                                               +s1.getCourseName()+"')");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
