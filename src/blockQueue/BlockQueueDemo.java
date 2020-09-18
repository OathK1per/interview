package blockQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 消息队列
 * @author Yuanping Zhang
 * @date
 */
public class BlockQueueDemo {

    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>(false);

        new Thread(() -> {
            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "\t put 1");

                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "\t put 2");

                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "\t put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAA").start();

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                String take = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + take);

                Thread.sleep(2000);
                take = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + take);

                Thread.sleep(2000);
                take = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "\t take " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "BBB").start();
    }
}
