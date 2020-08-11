package recursion;

import java.util.Scanner;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Loop {
    public static long loop(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long[] array = new long[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(System.currentTimeMillis());
            System.out.println(loop(num));
            System.out.println(System.currentTimeMillis());
        }
    }
}
