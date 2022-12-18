package SmallTeam;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class FinalClass{
    public static void main(String[] args) {
        Connection conn;
        PreparedStatement stmt;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai";
        String user = "root";
        String password = "hph2580@";
        String sql = "insert into Ticket values(Tno,TStart,TDest,TStartDate,TArrivalDate,TPrice,TCount)";
        TDateRevise date=new TDateRevise();
        //TPriceRevise price=new TPriceRevise();
        //Add add=new Add();
    }
}