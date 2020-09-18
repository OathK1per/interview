package countDown;

import java.util.concurrent.CountDownLatch;

/**
 * @author Yuanping Zhang
 * @date
 */
public enum CountEnum {
    ONE(1, "Jack", 21), TWO(2, "Bob", 24), THREE(3, "David", 12), FOUR(4, "Alex", 26), FIVE(5, "Katy", 33), SIX(6, "Curry", 29);

    private int num;
    private String name;
    private int age;

    public static CountEnum find(int num) {
        CountEnum[] values = CountEnum.values();
        for (CountEnum countEnum : values) {
            if (countEnum.num == num + 1) {
                return countEnum;
            }
        }
        return null;
    }

    CountEnum(int num, String name, int age) {
        this.num = num;
        this.name = name;
        this.age = age;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
