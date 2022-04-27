import java.sql.*;

public class test {
    public static void main(String[] args) {
        try {
            String url = "jdbc:ucanaccess://C://Users//Aryan//Documents//Lab3_db.accdb";
            Connection connect = DriverManager.getConnection(url, " ", " ");

            Statement stmt = connect.createStatement();
            String sql = "Select * from StudentsDB1";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getString(1) + " " + rs.getString(2) + "\n");

                
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
