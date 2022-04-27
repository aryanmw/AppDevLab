import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class StudentServlet extends HttpServlet{
    String message,Seat_no,Name,ans1,ans2,ans3,ans4,ans5;
    int Total=0;
    Connection connect;
    Statement stmt = null;
    ResultSet rs = null;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        try{
            String url = "jdbc:ucanaccess://C://Users//Aryan//Documents//Lab3_db.accdb";
            Connection connect = DriverManager.getConnection(url, " ", " ");
        }
    
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

        Seat_no = request.getParameter("Seat_no");
        Name = request.getParameter("Name");
        ans1 = request.getParameter("group1");
        ans2 = request.getParameter("group2");
        ans3 = request.getParameter("group3");
        ans4 = request.getParameter("group4");
        ans5 = request.getParameter("group5");

        if (ans1.equals("True")){
            Total+=2;
        }
        if (ans2.equals("True")){
            Total+=2;
        }
        if (ans3.equals("False")){
            Total+=2;
        }
        if (ans4.equals("False")){
            Total+=2;
        }
        if (ans5.equals("False")){
            Total+=2;
        }

        try {
            Statement stmt = connect.createStatement();
            String query = "INSERT INTO StudentsTable (" + "Seat_no,Name,Marks" + ") VALUES ('"
            +Seat_no + "', '" + Name + "', '"+Total+ "')";
            int result = stmt.executeUpdate(query);
            stmt.close();
            stmt = connect.createStatement();
            query = "SELECT * FROM StudentTable WHERE Name="+"'"+Name+"'";
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Thank you for taking the test</h1>");
        out.println("<table border=5>");
        out.println("<th>Seat Number</th>");
        out.println("<th>Name</th>");
        out.println("<th>Marks</th>");

        try{
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getInt(1)+"</td>");
                out.println("<td>"+rs.getString(2)+"</td>");
                out.println("<td>"+rs.getString(3)+"</td>");
                out.println("</tr>");
    
            }
            out.println("</table>");
            rs.close();
            stmt.close();
            connect.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        

        out.println("</center>");
        out.println("</body>");
        out.println("</html>");
    }


}