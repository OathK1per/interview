package interrupt;

import java.util.concurrent.TimeUnit;

/**
 * 结合前两个demo，如果没有形成阻塞仍然可以判断的方法
 * //判断是否被中断并清除当前中断状态（静态方法）
 * public static boolean Thread.interrupted();
 * @author Yuanping Zhang
 * @date
 */
public class InterruptDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.interrupted()) {
//                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (Exception e) {
                System.out.println("线程" + Thread.currentThread().getName() + "被中断");
                System.out.println(Thread.currentThread().isInterrupted());
            } finally {
                System.out.println("1");
            }
            System.out.println("2");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();
    }
}
