import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Database_Connections {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // Loading the Driver.
            String url = "jdbc:mysql://localhost:3306/temp";
            String username = "root";
            String Password = "ayushrawat@2003123" ;


            Connection con = DriverManager.getConnection(url,username,Password);
            if (con.isClosed())
            {
                System.out.println("Connection is closed ......");
            }
            else{
                System.out.println("Connection is not closed ..........");
            }



        }
        catch (Exception e)
        {
            System.out.println("Some error occurred ....");
        }
    }

}
