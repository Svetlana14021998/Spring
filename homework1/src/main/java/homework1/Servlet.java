package homework1;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


@WebServlet(name = "Servlet", urlPatterns = "/servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Product> products = initList();

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.printf("<html><body>");
        out.println("<h1>Products:</h1>");
        for (int i = 0; i < 10; i++) {
            out.printf("<h2>Product#" + products.get(i).id + "; title: " + products.get(i).title
                    + "; " + "cost: " + products.get(i).cost + "</h2>");
        }
        out.printf("</body></html>");
        out.close();
    }

    public ArrayList<Product> initList() {
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product(i, "product# " + i, i * 10));
        }
        return products;
    }

}