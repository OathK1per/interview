package countDown;

import java.util.concurrent.CountDownLatch;

/**
 * countDownLatch JUC下的倒计数
 * @author Yuanping Zhang
 * @date
 */
public class CountDownDemo {

    private static String[] array = new String[]{"Jack", "Bob", "David", "Alex", "Katy", "Curry"};

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            //线程中传入值，需使用final变量
            final int tem = i;
            new Thread(() -> {
//                System.out.println(array[tem] + "逃离现场");
                System.out.println(Thread.currentThread().getName() + "逃离现场");
                countDownLatch.countDown();
            }, CountEnum.find(tem).getName()).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("boom");
    }
}