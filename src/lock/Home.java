package lock;

/**
 * 可重入锁
 * @author Yuanping Zhang
 * @date
 */
public class Home implements Runnable {

    public synchronized void enterDoor() {
        System.out.println(Thread.currentThread().getName() + "\t enter the door");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        enterRoom();
    }

    public synchronized void enterRoom() {
        System.out.println(Thread.currentThread().getName() + "\t enter the room");
    }

    public static void main(String[] args) {
        Home home = new Home();
        new Thread(() -> {
            home.enterDoor();
        }, "t1").start();

        new Thread(() -> {
            home.enterDoor();
        }, "t2").start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(home, "t3").start();
        new Thread(home, "t4").start();
    }

    @Override
    public void run() {
        entrant();
    }

    public void entrant() {
        System.out.println(Thread.currentThread().getName() + "\t first");
        reentrant();
    }

    public void reentrant() {
        System.out.println(Thread.currentThread().getName() + "\t second");
    }
}
