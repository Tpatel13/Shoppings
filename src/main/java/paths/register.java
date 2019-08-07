package paths;

import bin.Register;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.UUID;


public class register extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700\" rel=\"stylesheet\">\n" +
                "<title>Bootstrap Simple Registration Form</title>\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n" +
                "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\">\n" +
                "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script> \n" +
                "<style type=\"text/css\">\n" +
                "\tbody{\n" +
                "\t\tcolor: #fff;\n" +
                "\t\tbackground: #63738a;\n" +
                "\t\tfont-family: 'Roboto', sans-serif;\n" +
                "\t}\n" +
                "    .form-control{\n" +
                "\t\theight: 40px;\n" +
                "\t\tbox-shadow: none;\n" +
                "\t\tcolor: #969fa4;\n" +
                "\t}\n" +
                "\t.form-control:focus{\n" +
                "\t\tborder-color: #5cb85c;\n" +
                "\t}\n" +
                "    .form-control, .btn{        \n" +
                "        border-radius: 3px;\n" +
                "    }\n" +
                "\t.signup-form{\n" +
                "\t\twidth: 400px;\n" +
                "\t\tmargin: 0 auto;\n" +
                "\t\tpadding: 30px 0;\n" +
                "\t}\n" +
                "\t.signup-form h2{\n" +
                "\t\tcolor: #636363;\n" +
                "        margin: 0 0 15px;\n" +
                "\t\tposition: relative;\n" +
                "\t\ttext-align: center;\n" +
                "    }\n" +
                "\t.signup-form h2:before, .signup-form h2:after{\n" +
                "\t\tcontent: \"\";\n" +
                "\t\theight: 2px;\n" +
                "\t\twidth: 30%;\n" +
                "\t\tbackground: #d4d4d4;\n" +
                "\t\tposition: absolute;\n" +
                "\t\ttop: 50%;\n" +
                "\t\tz-index: 2;\n" +
                "\t}\t\n" +
                "\t.signup-form h2:before{\n" +
                "\t\tleft: 0;\n" +
                "\t}\n" +
                "\t.signup-form h2:after{\n" +
                "\t\tright: 0;\n" +
                "\t}\n" +
                "    .signup-form .hint-text{\n" +
                "\t\tcolor: #999;\n" +
                "\t\tmargin-bottom: 30px;\n" +
                "\t\ttext-align: center;\n" +
                "\t}\n" +
                "    .signup-form form{\n" +
                "\t\tcolor: #999;\n" +
                "\t\tborder-radius: 3px;\n" +
                "    \tmargin-bottom: 15px;\n" +
                "        background: #f2f3f7;\n" +
                "        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);\n" +
                "        padding: 30px;\n" +
                "    }\n" +
                "\t.signup-form .form-group{\n" +
                "\t\tmargin-bottom: 20px;\n" +
                "\t}\n" +
                "\t.signup-form input[type=\"checkbox\"]{\n" +
                "\t\tmargin-top: 3px;\n" +
                "\t}\n" +
                "\t.signup-form .btn{        \n" +
                "        font-size: 16px;\n" +
                "        font-weight: bold;\t\t\n" +
                "\t\tmin-width: 140px;\n" +
                "        outline: none !important;\n" +
                "    }\n" +
                "\t.signup-form .row div:first-child{\n" +
                "\t\tpadding-right: 10px;\n" +
                "\t}\n" +
                "\t.signup-form .row div:last-child{\n" +
                "\t\tpadding-left: 10px;\n" +
                "\t}    \t\n" +
                "    .signup-form a{\n" +
                "\t\tcolor: #fff;\n" +
                "\t\ttext-decoration: underline;\n" +
                "\t}\n" +
                "    .signup-form a:hover{\n" +
                "\t\ttext-decoration: none;\n" +
                "\t}\n" +
                "\t.signup-form form a{\n" +
                "\t\tcolor: #5cb85c;\n" +
                "\t\ttext-decoration: none;\n" +
                "\t}\t\n" +
                "\t.signup-form form a:hover{\n" +
                "\t\ttext-decoration: underline;\n" +
                "\t}  \n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"signup-form\">\n" +
                "    <form action=\"\" method=\"post\">\n" +
                "\t\t<h2>Register</h2>\n" +
                "\t\t<p class=\"hint-text\">Create your account for Shopping Site. It's free and only takes a minute.</p>\n" +
                "        <div class=\"form-group\">\n" +
                "\t\t\t<div class=\"row\">\n" +
                "\t\t\t\t<div class=\"col-xs-6\"><input type=\"text\" class=\"form-control\" name=\"first_name\" placeholder=\"First Name\" required=\"required\"></div>\n" +
                "\t\t\t\t<div class=\"col-xs-6\"><input type=\"text\" class=\"form-control\" name=\"last_name\" placeholder=\"Last Name\" required=\"required\"></div>\n" +
                "\t\t\t</div>        \t\n" +
                "        </div>\n" +
                "        <div class=\"form-group\">\n" +
                "                <input type=\"text\" class=\"form-control\" name=\"address\" placeholder=\"Enter Address\" required=\"required\">\n" +
                "            </div>        \n" +
                "            <div class=\"form-group\">\n" +
                "                    <input type=\"number\" class=\"form-control\" name=\"phnumber\" placeholder=\"Enter Phone Number\" required=\"required\">\n" +
                "                </div>     \n" +
                "        <div class=\"form-group\">\n" +
                "        \t<input type=\"email\" class=\"form-control\" name=\"email\" placeholder=\"Email\" required=\"required\">\n" +
                "        </div>\n" +
                "\t\t<div class=\"form-group\">\n" +
                "            <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Password\" required=\"required\">\n" +
                "        </div>\n" +
                "\t\t<div class=\"form-group\">\n" +
                "            <input type=\"password\" class=\"form-control\" name=\"confirm_password\" placeholder=\"Confirm Password\" required=\"required\">\n" +
                "        </div>        \n" +
                "          \n" +
                "                    \n");
        out.print("<div>&nbsp;\n" +
                "\t\t&nbsp;\n" +
                "\t\t<input type =\"radio\" name=\"type\" value=\"admin\">  Admin&nbsp;&nbsp;\n" +
                "<input type =\"radio\" name=\"type\" value=\"customer\">  Customer&nbsp;&nbsp;\n" +
                "<input type =\"radio\" name=\"type\" value=\"merchant\">  Merchant<br></div><br>");
        out.println("        <div class=\"form-group\">\n" +
                "\t\t\t<br><label class=\"checkbox-inline\"><input type=\"checkbox\" required=\"required\"> I accept the <a href=\"#\">Terms of Use</a> &amp; <a href=\"#\">Privacy Policy</a></label>\n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"form-group\">\n" +
                "            <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\">Register Now</button>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "\t<div class=\"text-center\">Already have an account? <a href=\"/\">Sign in</a></div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>                            ");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Register r = new Register();
        String fname = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");

       // String address = request.getParameter("address");
        String phnumber = request.getParameter("phnumber");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String password = request.getParameter("password");
        String password2 = request.getParameter("confirm_password");


        if (!password.equals(password2)) response.sendRedirect("/register");

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");


            String query = "insert into users(id,fname,lname,email,password,phone,type)" + "value(?,?,?,?,?,?,?)";

            PreparedStatement statement = con.prepareStatement(query);
            UUID a = UUID.randomUUID();
            statement.setString(1, a.toString());
            statement.setString(2, fname);
            statement.setString(3, last_name);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setString(6, phnumber);
            statement.setString(7, type);

            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
