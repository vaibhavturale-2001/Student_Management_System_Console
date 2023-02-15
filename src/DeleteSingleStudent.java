import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteSingleStudent {
     void deleteSingleStudent(int rollNo){
         Boolean result=false;
         try{
             String url = "jdbc:mysql://localhost:3306/student-management-system";
             String user = "root";
             String pass = "";
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();
             int count=st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
             if(count>0){
                 result=true;
             }
         }catch(Exception e){
             System.out.println(e);
         }
         System.out.println(result);
     }
}
