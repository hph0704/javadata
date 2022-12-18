package SmallTeam;
import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
class Add {
    Add(){
        try {
            System.out.println("请输入要添加的机票号:");
            Scanner scanner = new Scanner(System.in);
            String TNo=scanner.nextLine();
            System.out.println("请输入此航班始发地:");
            Scanner scanner2 = new Scanner(System.in);
            String Tstart=scanner2.nextLine();
            System.out.println("请输入此航班目的地:");
            Scanner scanner3 = new Scanner(System.in);
            String Tdest=scanner3.nextLine();
            System.out.println("请输入此航班出发时间:");
            Scanner scanner4= new Scanner(System.in);
            String TStartDate=scanner4.nextLine();
            System.out.println("请输入此航班到达时间:");
            Scanner scanner5= new Scanner(System.in);
            String TArrivalDate=scanner5.nextLine();
            System.out.println("请输入此航班机票价格:");
            Scanner scanner6= new Scanner(System.in);
            String TPrice=scanner6.nextLine();
            System.out.println("请输入此机票剩余数量:");
            Scanner scanner7= new Scanner(System.in);
            String TCount=scanner7.nextLine();
            String sql = "insert into ticket values('"+TNo+"','" + Tstart + "','" + Tdest + "','"+TStartDate+"','"+TArrivalDate+"','"+TPrice+"','"+TCount+"')";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai","root","hph2580@");
            PreparedStatement stmt =con.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();//关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

