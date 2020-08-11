package recursion;

import java.util.Scanner;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Recursion {
    public static long recursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        return recursion(n - 1) + recursion(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(System.currentTimeMillis());
            System.out.println(recursion(num));
            System.out.println(System.currentTimeMillis());
        }
    }
}
