
package dac.servlets;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class FirstServlet extends HttpServlet {
   public void init(ServletConfig config) throws ServletException {
      super.init(config);
      System.out.println("FirstServlet.init() called");
}
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello DAC!!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
    public void destroy() {
       System.out.println("FirstServlet.destroy() called");
    }
}
