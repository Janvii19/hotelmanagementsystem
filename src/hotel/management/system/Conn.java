
package hotel.management.system;

import java.sql.*;


public class Conn  {
    Connection c;
    Statement s;
 Conn(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
        c= DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem1","root","jparmar$2002");
        s= c.createStatement();
    }catch(Exception e){
        System.out.println(e);
    }
}
}
