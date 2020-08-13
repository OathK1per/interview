package volatileKey;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuanping Zhang
 * @date
 * 不保证原子性的demo：多个线程大量循环调用num++来展示(看似一条代码，包含读到工作内存，增加值，写入主内存三个操作)，会出现写覆盖
 * 如何使其能够满足原子性：synchronized(奢侈)，JUC下的AtomicInteger，跟后面的CAS相关联
 */
class MyPlus {
    volatile AtomicInteger number = new AtomicInteger(0);

    void plus() {
        number.addAndGet(1);
    }
}

public class Atomic {

    public static void main(String[] args) {

        MyPlus plus = new MyPlus();

        for (int i = 0; i < 10; i++) {
            // new Runnable的Lambda写法
            new Thread(() -> {
                for (int j = 0; j < 2000; j++) {
                    plus.plus();
                }
            }, "Thread " + i).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(plus.number);
    }
}
