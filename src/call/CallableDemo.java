package call;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Yuanping Zhang
 * @date
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask<>(new MyThread());
        new Thread(task, "AAA").start();
        new Thread(task, "BBB").start();
        System.out.println(task.get());
    }
}


class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("***************enter callable*************");
        return 1024;
    }
}
