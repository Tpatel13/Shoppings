package validation;

import java.sql.*;

public class loginCheck {
   public static boolean status(String email,String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");
            PreparedStatement ps=con.prepareStatement("select email,password from users where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet s=ps.executeQuery();
            return s.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
            return false;
    }
}
