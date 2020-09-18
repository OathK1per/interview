package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author Yuanping Zhang
 * @date
 */
public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> o2 = new PhantomReference<>(o1, referenceQueue);
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(referenceQueue.poll());
        o1 = null;
        System.gc();
        System.out.println("++++++++++++++++++++++");
        System.out.println(o1);
        System.out.println(o2.get());
        System.out.println(referenceQueue.poll());
    }
}
