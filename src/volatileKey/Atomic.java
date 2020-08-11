package volatileKey;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yuanping Zhang
 * @date
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
