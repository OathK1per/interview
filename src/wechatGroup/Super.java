package wechatGroup;

/**
 * @author Yuanping Zhang
 * @date
 */
//调用父类的构造函数必须在类构造函数的第一行
public class Super extends Parent {
    public Super(String Name) {
        name = "Hello";
        super("kitty");
    }
}

class Parent {
    public String name;

    public Parent(String pName) {
        this.name = pName;
    }
}