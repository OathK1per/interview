package interrupt;

import java.util.concurrent.TimeUnit;

/**
 * interruptf方法对非阻塞的线程，需要手动判断是否中断，并手动停止
 * //判断线程是否被中断（实例方法）
 * public boolean Thread.isInterrupted();
 * @author Yuanping Zhang
 * @date
 */
public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("线程" + Thread.currentThread().getName() + "被中断");
                break;
            }

            System.out.println("2");
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);
        thread.interrupt();
    }
}
