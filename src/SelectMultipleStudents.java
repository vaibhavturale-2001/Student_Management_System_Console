import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectMultipleStudents {
    void selectMultipleStudents(List<Integer> rollNos){
        Student s1 = new Student();
        try{
            String url = "jdbc:mysql://localhost:3306/student-management-system";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            for(int i=0;i<rollNos.size();i++) {
                ResultSet rs = st.executeQuery("select * from student where rollNo='" +rollNos.get(i)+ "'");
                while (rs.next()) {
                    s1.setRollNo(rs.getInt(1));
                    s1.setName(rs.getString(2));
                    s1.setEmail(rs.getString(3));
                    s1.setBranch(rs.getString(4));
                    s1.setYear(rs.getString(5));
                    s1.setCourseName(rs.getString(6));
                    System.out.println("\n");
                    System.out.println("RollNo:"+s1.getRollNo()+"\n"+
                                       "Name:"+s1.getName()+"\n"+
                                       "Email:"+s1.getEmail()+"\n"+
                                       "Branch:"+s1.getBranch()+"\n"+
                                       "Year:"+s1.getYear()+"\n"+
                                       "Course_Name:"+s1.getCourseName());
                }

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
