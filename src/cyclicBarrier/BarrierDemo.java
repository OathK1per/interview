package cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier，JUC下的最终一致性，都完成后再开始某个线程
 * @author Yuanping Zhang
 * @date
 */
public class BarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> {
            System.out.println(Thread.currentThread().getName() + "正式开始");
        });

        for (int i = 1; i < 11; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "出列");
                try {
//                    System.out.println(cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "归队");
            }, String.valueOf(i)).start();
        }
    }
}
