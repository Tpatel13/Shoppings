package validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getUserType {
    public static String getUserType(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");
            PreparedStatement ps = con.prepareStatement("select type from users where email=?");
            ps.setString(1, email);

            ResultSet s = ps.executeQuery();
            String type = null;
           while (s.next()){
               return s.getString(1);
           }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }
}