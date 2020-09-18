package deadLock;

/**
 * @author Yuanping Zhang
 * @date
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String a = "AAA";
        String b = "BBB";
        new Thread(new DeadThread(a, b), "Thread-1").start();
        new Thread(new DeadThread(b, a), "Thread-2").start();
    }
}

class DeadThread implements Runnable {
    String lockA = "lockA";
    String lockB = "lockB";

    DeadThread(String a, String b) {
        lockA = a;
        lockB = b;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "获得" + lockA);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "获得" + lockB);
            }
        }
    }
}