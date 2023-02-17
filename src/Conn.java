
import java.sql.*;
public class Conn {

    Connection c;
    Statement s;

    Conn(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem","root","Monu*1234");
            s = c.createStatement();

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
