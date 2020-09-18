package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * GC Overhead Limit Exceeded
 * @author Yuanping Zhang
 * @date
 */
public class GCOverhead {
    public static void main(String[] args) {
        int i = 0;
        List<String> arrayList = new ArrayList<>();
        try {
            while (true) {
                arrayList.add(String.valueOf(++i).intern());
            }
        } catch (Throwable a) {
            System.out.println("++++++++++++++++" + i);
            a.printStackTrace();
        }
    }
}
