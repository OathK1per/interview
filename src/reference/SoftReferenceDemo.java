package reference;

import java.lang.ref.SoftReference;

/**
 * @author Yuanping Zhang
 * @date
 */
public class SoftReferenceDemo {
    public static void main(String[] args) {

//        enoughMemory();

        notEnoughMemory();
    }

    private static void enoughMemory() {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(o2.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(o2.get());
    }

    private static void notEnoughMemory() {
        Object o1 = new Object();
        SoftReference<Object> o2 = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(o2.get());

        o1 = null;

        try {
            Byte[] bytes = new Byte[30 * 1024 * 1024];
        } catch (Exception e) {

        } finally {
            System.out.println(o1);
            System.out.println(o2.get());
        }

    }
}
