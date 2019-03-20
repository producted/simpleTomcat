package learn;

/**
 * Created by zhangpk on 2019/3/18
 **/
public class test {
    public static void main(String[] args) {
        //带你了解\n代表行 \\s代表空格
        String a = "hello" + "\n" + "world！";
        String[] split = a.split("\\n");
        System.out.println(split[0]);
        String b = "hello" + "\n" + "world！";
        String[] split1 = b.split("\\s");
        System.out.println(split1[1]);
        String c = "zhang" + "\r\n" + "peike";
        System.out.println(c);
    }
}
