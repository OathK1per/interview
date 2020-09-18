package oom;

/**
 * Java Heap Space
 * @author Yuanping Zhang
 * @date
 */
public class HeapSpace {
    public static void main(String[] args) {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(totalMemory / (double)1024 / 1024 );
        System.out.println(maxMemory / (double)1024 / 1024 );
        Byte[] bytes = new Byte[50 * 1024 * 1024];
    }
}
