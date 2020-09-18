package helloGC;

import java.util.Random;

/**
 * 修改配置可使用7大垃圾收集器
 * @author Yuanping Zhang
 * @date
 */
public class GCDemo {
    public static void main(String[] args) {
        System.out.println("GCDEMO");
        try {
            String str = "GC";
            while (true) {
                str += str + new Random().nextInt(1111111111) + new Random().nextInt(222222222);
                str.intern();
            }
        } catch (Throwable a) {
            a.printStackTrace();
        }
    }
}
