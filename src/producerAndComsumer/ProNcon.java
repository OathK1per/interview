package producerAndComsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者传统版
 * @author Yuanping Zhang
 * @date
 */
public class ProNcon {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                resource.increment();
                System.out.println(Thread.currentThread().getName() + "\t" + resource.getNumber());
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                resource.decrement();
                System.out.println(Thread.currentThread().getName() + "\t" + resource.getNumber());
            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                resource.increment();
                System.out.println(Thread.currentThread().getName() + "\t" + resource.getNumber());
            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                resource.decrement();
                System.out.println(Thread.currentThread().getName() + "\t" + resource.getNumber());
            }
        }, "DDD").start();
    }
}

class Resource {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            condition.signalAll();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() {
        lock.lock();
        try {
            while (number == 0) {
                condition.await();
            }
            number--;
            condition.signalAll();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
