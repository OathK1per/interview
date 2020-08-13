package container;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Yuanping Zhang
 * @date
 * 集合类的线程不安全
 * 学习原码为主
 */
public class Container {

    public static void main(String[] args) {
        //只适用于固定长度的数组转容器，容器长度不可变
//        String[] array = new String[]{"a", "b", "c"};
//        List<String> list = Arrays.asList(array);
//        list.forEach(System.out::println);
//        array[0] = "d";
//        list.forEach(System.out::println);

        Collections.synchronizedList(new ArrayList<>()).add(1);
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
