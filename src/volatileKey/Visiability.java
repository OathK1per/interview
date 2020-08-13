package volatileKey;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Yuanping Zhang
 * @date
 * 可见性的demo：主内存中内容，与工作内存中副本拷贝导致了可见性。
 */
class MyData {
    int number = 0;

    void change() {
        this.number = 60;
    }
}
public class Visiability {

    public static void main(String[] args) {

        MyData data = new MyData();

//        System.out.println(data.number);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t comes in");
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (Visiability.class) {
                System.out.println("change");
                data.change();
            }
            System.out.println(Thread.currentThread().getName() + "\t changes to " + data.number);
        }, "AAA").start();


        System.out.println(Thread.currentThread().getName() + "\t continues");
        synchronized (MyData.class) {
            while (data.number == 0) {
                System.out.println("wait");
//                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t is over");
    }
}
