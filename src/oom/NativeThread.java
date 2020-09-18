package oom;

/**
 * unable to create new native thread
 * @author Yuanping Zhang
 * @date
 */
public class NativeThread {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
            i++;
        }
    }
}
