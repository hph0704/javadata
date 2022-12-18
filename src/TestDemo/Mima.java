package TestDemo;
import java.util.Scanner;
public class Mima {
    public static void main(String[] args){
        System.out.println("请输入您要进行修改操作的机票票号:");
        Scanner scanner0 = new Scanner(System.in);
        String phone = scanner0.nextLine();
        String card = "6554847225603159842";
        String string = phone.replaceAll("(\\d{0})\\d{6}(\\d{0})", "$1****$2");
        System.out.println(string);
    }
}
