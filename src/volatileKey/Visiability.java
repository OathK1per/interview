package volatileKey;

/**
 * @author Yuanping Zhang
 * @date
 */
class MyData {
    int number = 0;

    void change() {
        this.number = 60;
    }
}
public class Visiability {

    public static void main(String[] args) {

        MyData data = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t comes in");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.change();
            System.out.println(Thread.currentThread().getName() + "\t changes to " + data.number);
        }, "AAA").start();


        System.out.println(Thread.currentThread().getName() + "\t continues");
        while (data.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t is over");
    }
}
