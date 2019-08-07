package paths;

import bin.Products;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class merchant extends HttpServlet {
    static ArrayList<Products> products = new ArrayList<>();
    static String merchantID = null;

    @Override
    public void init() throws ServletException {
        super.init();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        if (request.getSession() == null) {
            response.sendRedirect("/");
        }

        HttpSession session = request.getSession();
        merchantID = session.getAttribute("merchant").toString();
        getProducts();


        //Nav Header
        out.println("<HTML>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">    \n" +
                "    <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "<body>\n" +
                "    <div>\n" +
                "    <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "   \n" +
                "    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "      <span class=\"navbar-toggler-icon\"></span>\n" +
                "    </button>\n" +
                "  \n" +
                "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
                "      <ul class=\"navbar-nav mr-auto\">\n" +
                "        <li class=\"nav-item active\">\n" +
                "          <a class=\"nav-link\" href=\"#\">Home <span class=\"sr-only\">(current)</span></a>\n" +
                "        </li>\n" +
                "<!-- \n" +
                "        <li class=\"nav-item\">\n" +
                "          <a class=\"nav-link\" href=\"#\">Link</a>\n" +
                "        </li> -->\n" +
                "        <li class=\"nav-item dropdown\">\n" +
                "          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                "            Pages\n" +
                "          </a>\n" +
                "          <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n" +
                "            <a class=\"dropdown-item\" href=\"#\">List of Users</a>\n" +
                "            <a class=\"dropdown-item\" href=\"#\">Merchant List</a>\n" +
                "            \n" +
                "        <a class=\"dropdown-item\" href=\"#\">All products</a>\n" +
                "          </div>\n" +
                "        </li>\n" +
                "        <li class=\"nav-item\">\n" +
                "          <a class=\"nav-link disabled\" href=\"#\"></a>\n" +
                "        </li>\n" +
                "      </ul>\n" +
                "      <form class=\"form-inline my-2 my-lg-0\">\n" +
                "        <input class=\"form-control mr-sm-2\" type=\"search\" name =\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
                "        <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </nav>\n" +
                "</div>");
        out.println("\n" +
                "<div class=\"mx-auto\">\n" +
                "<table class=\"table\">\n" +
                "  <thead class=\"thead-dark\">\n" +
                "    <tr>\n" +
                "      <th scope=\"col\">#</th>\n" +
                "      <th scope=\"col\">Product Name</th>\n" +
                "      <th scope=\"col\">Product Description</th>\n" +
                "      <th scope=\"col\">Price</th>\n" +
                "      <th scope=\"col\">Action</th>\n" +
                "    </tr>\n" +
                "  </thead>\n" +
                "  <tbody>\n" );

        products.forEach(element->{
            out.println("<tr>\n" +
                    "      <th scope=\"row\">"+element.getId()+"</th>\n" +
                    "      <td>"+element.getName()+"</td>\n" +
                    "      <td>"+element.getDescription()+"</td>\n" +
                    "      <td>"+element.getPrice()+"</td>\n" +
                    "      <td><a href=\"delete?id="+element.getId()+"\">delete</a></td>\n" +
                    "   \n" +
                    "    </tr>");
        });

        out.println("  </tbody>\n" +
                "</table>\n\n" +
                "<div class=\"container w-25\">\n" +
                "<form action=\"addProduct\" method=\"post\">\n" +
                "  <h3><span class=\"badge badge-secondary\">Add products</span></h3>\n" +
                "  <div class=\"form-group\">\n" +
                "  <label> Name</label>\n" +
                "  <input class=\"form-control\" name=\"name\" type=\"text\">\n" +
                "</div>\n" +
                " \n" +
                "  <div class=\"form-group\">\n" +
                "    <label > Price</label>\n" +
                "    <input class=\"form-control\" name=\"price\" type=\"text\">\n" +
                "  </div> <div class=\"form-group\">\n" +
                "      <label for=\"formGroupExampleInput\"> Description</label>\n" +
                "      <input class=\"form-control h-25\" name=\"description\" type=\"text\">\n" +
                " <input type=\"hidden\" value="+merchantID+" name=\"merchantID\">\n" +
                "  </div>\n" +
                "  <button type=\"submit\" class=\"btn btn-primary\">Add Product</button>\n" +
                "</form>\n" +
                "</div>" +
                "</div></body>\n" +
                "</HTML>");
products=new ArrayList<>();


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    public void getProducts() {


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root154516");


            String query = "select * from products where merchentID=?";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, merchantID);
            ResultSet result = statement.executeQuery();


            while (result.next()) {
                Products product = new Products();
                product.setId(result.getInt("productid"));
                product.setName(result.getString("productname"));
                product.setDescription(result.getString("productdescription"));
                product.setPrice(result.getInt("price"));
                products.add(product);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
