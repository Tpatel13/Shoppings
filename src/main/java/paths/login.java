package paths;

import validation.getUserType;
import validation.loginCheck;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.print("<html>\n" +
                "\n" +
                "<head>\n" +
                "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
                "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container \">\n" +
                "<div class=\"pagination-centered\">\n" +
                "        <form action=\"\" method=\"POST\">\n" +
                "          <div class=\"form-group\">\n" +
                "            <label for=\"exampleInputEmail1\">Email address</label>\n" +
                "            <input type=\"email\" class=\"form-control\" name=\"email\" aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\n" +
                "            <small id=\"emailHelp\" class=\"form-text text-muted\"></small>\n" +
                "          </div>\n" +
                "          <div class=\"form-group\">\n" +
                "            <label for=\"exampleInputPassword1\">Password</label>\n" +
                "            <input type=\"password\" class=\"form-control\" password=\"password\"  name=\"password\" placeholder=\"Password\">\n" +
                "          </div>\n" +
                "          <button type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "\n" +
                "</div>\n");
        out.println("<div class=\"row\">\n" +
                "\t\t<div class=\"col-sm\">\n" +
                "\t\t  \n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"col-sm\">\n" +
                "\t\t \n" +
                "\t\t</div>\n" +
                "\t\t<div class=\"col-sm\">\n" +
                "Dont Have an account ?<a href=\"register\" class=\"badge badge-primary\">register</a>\n" +
                "\t\t</div>\n" +
                "\t  </div>");
        out.println(
                "</body>\n" +
                        "</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (loginCheck.status(email, password)) {
            String type = getUserType.getUserType(email);
            HttpSession s=request.getSession();

            if (type.equals("admin")) {

                 s.setAttribute("type","admin");
                response.sendRedirect("/admin");
            } else if (type.equals("merchant")) {
                s.setAttribute("type","merchant");
                response.sendRedirect("/merchant");
            } else {
                s.setAttribute("type","customer");
                response.sendRedirect("/customer");
            }


        } else response.sendRedirect("/");
    }


}

