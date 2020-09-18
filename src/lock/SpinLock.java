package lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * 线程操纵资源类
 * @author Yuanping Zhang
 * @date
 */
public class SpinLock {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    private void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println("线程已进入:" + thread.getName());
        while(!atomicReference.compareAndSet(null, thread)) {

        }
        System.out.println("线程已被锁定:" + thread.getName());
    }

    private void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println("线程已被释放:" + thread.getName());
    }


    public static void main(String[] args) {
        SpinLock lock = new SpinLock();
        new Thread(() -> {
            lock.myLock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.myUnlock();
        }, "t1").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.myLock();
        lock.myUnlock();

    }
}
