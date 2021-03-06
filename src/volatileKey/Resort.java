package volatileKey;

import com.sun.corba.se.pept.transport.ReaderThread;

/**
 * @author Yuanping Zhang
 * @date
 * 禁止指令重排：通过插入内存屏障来禁止屏障前后的指令发生重排优化
 */
public class Resort {
    private static int number = 0;

    private static boolean ready = false;

    private static class WriterThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 24;
            ready = true;
            System.out.println(Thread.currentThread().getName() + ": change");
        }
    }

    public static void main(String[] args) {
        WriterThread thread3 = new WriterThread();
        thread3.start();
        while (!ready) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ": " + number);
    }
}

class Student {
    public int age;

    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
