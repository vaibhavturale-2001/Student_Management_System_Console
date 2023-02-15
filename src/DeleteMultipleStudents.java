import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteMultipleStudents {
    void deleteMultipleStudent(List<Integer>rollNos){
        Boolean result=false;
        try{
            String url = "jdbc:mysql://localhost:3306/student-management-system";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            for(int i=0;i< rollNos.size();i++) {
                int count=st.executeUpdate("delete from student where rollNo='" + rollNos.get(i) + "'");
                if(count>0){
                    result=true;
                    System.out.println(result);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
