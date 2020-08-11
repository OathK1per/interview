package init;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Son extends Father {
    public static int i = one();
    public int j = two();

    static {
        System.out.println("6");
    }

    public Son() {
        System.out.println("7");
    }

    {
        System.out.println("8");
    }

    public static int one() {
        System.out.println("9");
        return 1;
    }

    @Override
    public int two() {
        System.out.println("0");
        return 1;
    }
}
