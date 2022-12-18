package SmallTeam;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


class TPriceRevise {
    String MNo="471094";
    String TPrice;
    public void MNo(String Mno){
        MNo=Mno;
    }
    Calendar cal=Calendar.getInstance();

    TPriceRevise(){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            System.out.println("当前时间：" + sdf.format(now));
            System.out.println("请输入您要进行修改操作的机票票号:");
            Scanner scanner0 = new Scanner(System.in);
            String TNo=scanner0.nextLine();
            System.out.println("请输入对应操作号码:");
            System.out.println("**********\n"+
                               "1.票价上涨\n" +
                               "2.票价下调\n" +
                               "**********");
            System.out.println("请输入对应操作号码值:");
            Scanner input = new Scanner(System.in);
            int choose=input.nextInt();
            switch(choose){
                case 1:
                    System.out.println("请输入价格上涨数值:");
                    Scanner scanner1 = new Scanner(System.in);
                    String m=scanner1.nextLine();
                    int m1=Integer.parseInt(m);
                    String sql1="update Ticket set TPrice=TPrice+"+m1+" where TNo='"+TNo+"';";
                    String sql2="insert into MannageTicket values('"+MNo+"','"+TNo+"','"+sdf.format(now)+"','票价上涨','"+m1+"');";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con1= DriverManager.getConnection("jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai","root","hph2580@");
                    PreparedStatement stmt1=con1.prepareStatement(sql1);
                    PreparedStatement stmt2=con1.prepareStatement(sql2);
                    stmt1.executeUpdate();
                    stmt2.executeUpdate();
                    stmt1.close();//关闭资源
                    stmt2.close();
                    break;
                case 2:
                    System.out.println("请输入价格下调数值(请输入负值):");
                    Scanner scanner2 = new Scanner(System.in);
                    String n=scanner2.nextLine();
                    String sql11="update Ticket set TPrice=TPrice+"+n+" where TNo='"+TNo+"';";
                    String sql22="insert into MannageTicket values('"+MNo+"','"+TNo+"','"+sdf.format(now)+"','票价下调','"+n+"');";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con2= DriverManager.getConnection("jdbc:mysql://localhost:3306/adddata?useSSL=false&serverTimezone=Asia/Shanghai","root","hph2580@");
                    PreparedStatement stmt11=con2.prepareStatement(sql11);
                    PreparedStatement stmt22=con2.prepareStatement(sql22);
                    stmt11.executeUpdate();
                    stmt22.executeUpdate();
                    stmt11.close();//关闭资源
                    stmt22.close();
                    break;
            }

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}