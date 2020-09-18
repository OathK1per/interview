package threadPool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池的三种方式，更推荐使用ThreadPoolExecutor去手动创建
 * @author Yuanping Zhang
 * @date
 */
public class threadPoolDemo {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                new ThreadFactory() {
                    private final String namePrefix = "ThreadPool-1-Thread-";
                    private volatile AtomicInteger i = new AtomicInteger(0);
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t = new Thread(r, namePrefix + i.incrementAndGet());
                        return t;
                    }
                },
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 20; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}
