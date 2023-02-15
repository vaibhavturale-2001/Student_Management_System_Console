import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectSingleStudent {
    void selectStudent(int rollNo){
        Student s3=new Student();
        try {
            String url = "jdbc:mysql://localhost:3306/student-management-system";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while(rs.next()){
                s3.setRollNo(rs.getInt(1));
                s3.setName(rs.getString(2));
                s3.setEmail(rs.getString(3));
                s3.setBranch(rs.getString(4));
                s3.setYear(rs.getString(5));
                s3.setCourseName(rs.getString(6));
            }
            System.out.println("RollNo:"+s3.getRollNo()+"\n"+
                               "Name:"+s3.getName()+"\n"+
                               "Email:"+s3.getEmail()+"\n"+
                               "Branch:"+s3.getBranch()+"\n"+
                               "Year:"+s3.getYear()+"\n"+
                               "Course_Name:"+s3.getCourseName());
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
