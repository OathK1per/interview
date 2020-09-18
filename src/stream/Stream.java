package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Yuanping Zhang
 * @date
 */
class Person {
    private String name;
    private Integer age;
    private String country;
    private char gender;

    public Person(String name, Integer age, String country, char gender) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}

public class Stream {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("欧阳雪",18,"中国",'F'));
        personList.add(new Person("Tom",24,"美国",'M'));
        personList.add(new Person("Harley",22,"英国",'F'));
        personList.add(new Person("向天笑",20,"中国",'M'));
        personList.add(new Person("李康",22,"中国",'M'));
        personList.add(new Person("小梅",20,"中国",'F'));
        personList.add(new Person("何雪",21,"中国",'F'));
        personList.add(new Person("李康",22,"中国",'M'));

//        List<Person> list = personList.stream().filter(person -> person.getAge() > 18).collect(Collectors.toList());
//        list.forEach(person -> System.out.println(person.getName()));
        personList.stream().filter(person -> person.getAge() > 18).forEach(System.out::println);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
// 获取空字符串的数量
        long count = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println(count);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Double> squaresList = numbers.stream().map(Math::sqrt).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        final boolean adult = personList.stream().allMatch(p -> p.getAge() >= 18);
        System.out.println("是否都是成年人：" + adult);
        List<Integer> integerList = new ArrayList<>(100);
        for(int i = 1;i <= 100;i++) {
            integerList.add(i);
        }
        Integer reduce = integerList.stream().reduce(0, Math::max);
        System.out.println("结果为：" + reduce);
    }
}
