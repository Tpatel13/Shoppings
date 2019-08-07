package validation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class getUserType {
    public static HashMap<String, String> getUserType(String email) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");
            PreparedStatement ps = con.prepareStatement("select type,id from users where email=?");
            ps.setString(1, email);

            ResultSet s = ps.executeQuery();
            HashMap<String, String> userData = new HashMap<String, String>();

            while (s.next()) {
                System.out.println(s.getString(1) +"   ////   "+s.getString(2));
                userData.put(s.getString(1), s.getString(2));
                return userData;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}