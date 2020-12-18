package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * java8常用的函数式接口
 * Predicate,Function,Consumer,Supplier,UnaryOperator,BinaryOperator
 * @author Yuanping Zhang
 * @date
 */
public class MethodInterface {
    public static void main(String[] args) {
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("欧阳雪",18,"中国",'F'));
//        personList.add(new Person("Tom",24,"美国",'M'));
//        personList.add(new Person("Harley",22,"英国",'F'));
//        personList.add(new Person("向天笑",20,"中国",'M'));
//        personList.add(new Person("李康",22,"中国",'M'));
//        personList.add(new Person("小梅",20,"中国",'F'));
//        personList.add(new Person("何雪",21,"中国",'F'));
//        personList.add(new Person("李康",22,"中国",'M'));

        //返回的是boolean
        Person person = new Person("欧阳雪",18,"中国",'F');
        Predicate<Person> predicate1 = (x) -> x.getAge() > 20;
        System.out.println(predicate1.test(person));

        Predicate<Integer> predicate2 = (x) -> x < 20;
        System.out.println(predicate2.test(person.getAge()));

        //没有返回值
        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("这个世界V在CD");

        Consumer<Person> consumer2 = (x) -> System.out.println(x.getName());
        consumer2.accept(person);

        //传入前一个参数，返回后一个参数
        Function<Person, String> function = Person::getCountry;
        System.out.println(function.apply(person));

        //没有传参，返回一个对象
        Supplier<String> supplier = () -> "将登太行雪满山";
        System.out.println(supplier.get());

        UnaryOperator<Person> unaryOperator = (p) -> {p.setName("新同学"); return p;};
        System.out.println(unaryOperator.apply(person).getName());
    }
}
