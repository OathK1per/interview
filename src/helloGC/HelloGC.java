package helloGC;

/**
 * @author Yuanping Zhang
 * @date
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        long totalMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println(totalMemory / (double)1024 / 1024 );
        System.out.println(maxMemory / (double)1024 / 1024 );
        System.out.println("HelloGC");
        Byte[] bytes = new Byte[50 * 1024 * 1024];
//        Thread.sleep(Integer.MAX_VALUE);
    }
}
