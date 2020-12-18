package wechatGroup;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Plus {
    static String a = "1";
    static int b = 1;

    //方法中均为局部变量，在方法结束后销毁，不能设置static变量
    public static void main(String[] args) {
        static int c = 2;
        System.out.println(a + b + c);
    }
}
