package pass;

import init.Father;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Pass {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        String str2 = new String();
        Integer j = 200;
        int[] arr = {1,2,3,4,5};
        Father father = new Father();

//        List<String> list = new ArrayList<>();
//        list.add("same");
//        ArrayList<String> newList = new ArrayList<String>(list.clone());
//        if (list.get(0).equals(newList.get(0))) {
//            System.out.println("same");
//        }
//        String string = list.get(0);
//        string.concat(", no!");
//        list.add(0, string);
//        System.out.println(newList.get(0));
//        System.out.println(list.get(0));
//        if (list.get(0).equals(newList.get(0))) {
//            System.out.println("same");
//        }

        change(i, str, j, arr, father, str2);

        System.out.println(i);
        System.out.println(str);
        System.out.println(j);
        System.out.println(arr[0]);
        System.out.println(father.j);
        System.out.println(str2);
    }

    public static void change(int i, String s, Integer j, int[] arr, Father f, String s2) {
        i += 1;
        s += "world";
        j += 1;
        arr[0] += 1;
        f.j += 1;
        s2.concat("67890");
    }
}

