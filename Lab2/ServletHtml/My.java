import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class My extends HttpServlet{

public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

PrintWriter p = res.getWriter();
p.println("hello servlet");

}

}