package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author Yuanping Zhang
 * @date
 */
public class ReadAndWriteLock {

    private Map<String, Object> map = new ConcurrentHashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void put(String str, Object obj) {
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t放入元素" + obj);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(str, obj);
            System.out.println(Thread.currentThread().getName() + "\t放入元素成功");
        } finally {
            lock.writeLock().unlock();
        }
    }

    void get(String str) {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t获得元素");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object obj = map.get(str);
            System.out.println(Thread.currentThread().getName() + "\t获得元素成功" + obj);
        } finally {
            lock.readLock().unlock();
        }
    }


}

class Demo {
    public static void main(String[] args) {
        ReadAndWriteLock lock = new ReadAndWriteLock();

        for (int i = 0; i < 5; i++) {
            final int tem = i;
            new Thread(() -> {
                lock.put(String.valueOf(tem), tem);
            }, String.valueOf(tem)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tem = i;
            new Thread(() -> {
                lock.get(String.valueOf(tem));
            }, String.valueOf(tem)).start();
        }
    }
}
