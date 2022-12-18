package SmallTeam;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

class TDateRevise {
    String MNo="429784";
    public void MNo(String Mno){
        MNo=Mno;
    }
    TDateRevise(){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            System.out.println("当前时间：" + sdf.format(now));
            System.out.println("请输入您要进行修改操作的机票票号:");
            Scanner scanner0 = new Scanner(System.in);
            String TNo = scanner0.nextLine();
            String sql0 = "select TStartDate,TArrivalDate from Ticket where TNo='" + TNo + "';";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con0 = DriverManager.getConnection("jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai", "root", "hph2580@");
            PreparedStatement stmt0 = con0.prepareStatement(sql0);
            ResultSet rs1 = stmt0.executeQuery(sql0);
            if (rs1.next()) {
                System.out.println("此航班出发时间:"+rs1.getString("TStartDate"));
                System.out.println("此航班到达时间:"+rs1.getString("TArrivalDate"));
            }
            String TStartDate = rs1.getString("TStartDate");
            String TStartDate2 = rs1.getString("TArrivalDate");
            Date date1=sdf.parse(TStartDate);
            Date date2=sdf.parse(TStartDate2);
            stmt0.close();
            con0.close();
            System.out.println("请输入此航班延误数值:");
            Scanner scanner1 = new Scanner(System.in);
            String m= scanner1.nextLine();
            int m1=Integer.parseInt(m);
            Calendar calendar1=Calendar.getInstance();
            Calendar calendar2=Calendar.getInstance();
            calendar1.setTime(date1);
            calendar2.setTime(date2);
            calendar1.add(Calendar.MINUTE, m1);
            calendar2.add(Calendar.MINUTE, m1);
            String sql1 = "update Ticket set TStartDate='" +sdf.format(calendar1.getTime())+ "'where TNo='" + TNo + "';";
            String sql2 = "update Ticket set TArrivalDate='" +sdf.format(calendar2.getTime()) + "'where TNo='" + TNo + "';";
            String sql3 = "insert into MannageTicket values('" + MNo + "','" + TNo + "','" + sdf.format(now) + "','时间延迟','" + m1 + "');";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai", "root", "hph2580@");
            PreparedStatement stmt1 = con1.prepareStatement(sql1);
            PreparedStatement stmt2 = con1.prepareStatement(sql2);
            PreparedStatement stmt3 = con1.prepareStatement(sql3);
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            stmt3.executeUpdate();
            stmt1.close();//关闭资源
            stmt2.close();
            stmt3.close();
        }catch(ParseException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
