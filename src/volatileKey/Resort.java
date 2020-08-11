package volatileKey;

import com.sun.corba.se.pept.transport.ReaderThread;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Resort {
    private static int number;

    private static class WriterThread extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + ": change");
        }
    }

    public static void main(String[] args) {
        int count = 0;
        while (number == count) {
            WriterThread thread3 = new WriterThread();
            thread3.start();
            count++;
            while (count != number) {
                Thread.yield();
            }
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
