package producerAndComsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者消费者模式阻塞队列版
 * @author Yuanping Zhang
 * @date
 */
public class NewProNCon {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue(3));

        new Thread(() -> {
            myResource.MyProduce();
        }, "Produce").start();

        new Thread(() -> {
            myResource.MyConsumer();
        }, "Consumer").start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myResource.stop();
        System.out.println("stop");
    }
}

class MyResource {

    boolean flag = true;
    volatile AtomicInteger number = new AtomicInteger();
    BlockingQueue<Integer> blockingQueue = null;

    MyResource(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    void MyProduce() {


        while (flag) {
            number.incrementAndGet();
            try {
                boolean offer = blockingQueue.offer(number.intValue(), 2L, TimeUnit.SECONDS);
                if (offer) {
                    System.out.println(Thread.currentThread().getName() + "\t 生产成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t 生产失败");
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产");
    }

    void MyConsumer() {
        Integer value = null;
        while (flag) {
            try {
                value = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (value == null) {
                    flag = false;
                    System.out.println(Thread.currentThread().getName() + "\t 等待时间过长");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费成功 " + value);
        }
    }

    void stop() {
        flag = false;
    }
}