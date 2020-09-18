package interrupt;

import java.util.concurrent.TimeUnit;

/**
 * interruptf方法对阻塞的线程能够中断并且复位，抛出异常，此时判断interrupted为false
 * //中断线程（实例方法）
 * public void Thread.interrupt();
 * @author Yuanping Zhang
 * @date
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (InterruptedException e) {
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
