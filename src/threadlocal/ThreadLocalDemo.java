package threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

/**
 * threadLocal，变量在不同线程中保存一个本地副本，该线程只能操作本地副本
 * @author Yuanping Zhang
 * @date
 */
public class ThreadLocalDemo {

    private static final ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "欲渡黄河冰塞川");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
                threadLocal.set("6657");
                System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            }).start();
        }

//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.tryLock();
    }
}
