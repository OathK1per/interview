package pass;

import init.Father;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Pass {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer j = 200;
        int[] arr = {1,2,3,4,5};
        Father father = new Father();

        change(i, str, j, arr, father);

        System.out.println(i);
        System.out.println(str);
        System.out.println(j);
        System.out.println(arr[0]);
        System.out.println(father.j);
    }

    public static void change(int i, String s, Integer j, int[] arr, Father f) {
        i += 1;
        s += "world";
        j += 1;
        arr[0] += 1;
        f.j += 1;
    }
}
