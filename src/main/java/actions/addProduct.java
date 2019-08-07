package actions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

public class addProduct extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String price=request.getParameter("price");
        String info=request.getParameter("description");
        if (request.getSession() == null) {
            response.sendRedirect("/");
        }
        HttpSession session = request.getSession();
        String merchantID = session.getAttribute("merchant").toString();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");


            String query = "insert into products(productname,productdescription,price,merchentID)" + "value(?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1,name);
            statement.setString(2, info);
            statement.setDouble(3, Double.parseDouble(price));
            statement.setString(4, merchantID);

            statement.execute();
        response.sendRedirect("merchant");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
