package init;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Father {
    public static int i = one();
    public int j = two();

    static {
        System.out.println("1");
    }

    public Father() {
        System.out.println("2");
    }

    {
        System.out.println("3");
    }

    public static int one() {
        System.out.println("4");
        return 1;
    }

    public int two() {
        System.out.println("5");
        return 1;
    }
}
