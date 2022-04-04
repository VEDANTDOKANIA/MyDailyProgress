package Database;
import java.sql.*;

public class jdbcConnection {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vdatabase","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from vdata");
            System.out.println(rs.findColumn("id"));

            while(rs.next())
            {System.out.println(rs.findColumn("id"));
            }
            con.close();
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
