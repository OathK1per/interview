package producerAndComsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock实现精确唤醒功能
 * @author Yuanping Zhang
 * @date
 */
public class AccurateNotify {

    public static void main(String[] args) {
        Notify notify = new Notify();
        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                notify.incrementA();
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                notify.decrementB();

            }
        }, "BBB").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                notify.incrementC();

            }
        }, "CCC").start();

        new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                notify.decrementD();

            }
        }, "DDD").start();
    }
}

class Notify {

    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition toA = lock.newCondition();
    private Condition toB = lock.newCondition();
    private Condition toC = lock.newCondition();
    private Condition toD = lock.newCondition();


    public void incrementA() {
        lock.lock();
        try {
            while (number != 0) {
                toA.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "\t" + getNumber());
            toD.signal();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void incrementC() {
        lock.lock();
        try {
            while (number != 3) {
                toC.await();
            }
            number = 0;
            System.out.println(Thread.currentThread().getName() + "\t" + getNumber());
            toA.signal();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrementB() {
        lock.lock();
        try {
            while (number != 2) {
                toB.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName() + "\t" + getNumber());
            toC.signal();
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decrementD() {
        lock.lock();
        try {
            while (number != 1) {
                toD.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "\t" + getNumber());
            toB.signal();
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
