import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSingleStudent {
    void updateSingle(){
        Scanner sc=new Scanner(System.in);
        SelectSingleStudent ss=new SelectSingleStudent();
        Student s4=new Student();
        System.out.println("Update the details of Single Student:\n");
        System.out.println("Enter the RollNo of Student:");
        s4.setRollNo(sc.nextInt());
        System.out.println("Enter the Name of Student:");
        s4.setName(sc.next());
        System.out.println("Enter the Email of Student:");
        s4.setEmail(sc.next());
        System.out.println("Enter the Branch of Student:");
        s4.setBranch(sc.next());
        System.out.println("Enter the Year of Student:");
        s4.setYear(sc.next());
        System.out.println("Enter the Course_Name of Student:");
        s4.setCourseName(sc.next());
        try{
            String url="jdbc:mysql://localhost:3306/student-management-system";
            String user="root";
            String pass="";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,user,pass);
            Statement st=con.createStatement();
            st.executeUpdate("update student set name='"+s4.getName()
                                                  +"',email='"+s4.getEmail()
                                                  +"',branch='"+s4.getBranch()
                                                  +"',year='"+s4.getYear()
                                                  +"',courseName='"+s4.getCourseName()
                                                  +"' where rollNo='"+s4.getRollNo()+"'");
        }catch(Exception e){
            System.out.println(e);
        }
        ss.selectStudent(s4.getRollNo());
    }
}
