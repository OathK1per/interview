package field;

/**
 * @author Yuanping Zhang
 * @date
 */
public class Field {
    public static int i;
    public int j;
    public int k;
    {
        int i = 1;
        Field.i++;
        j++;
        k++;
    }
    public void test(int j) {
        j++;
        i++;
        k++;
    }
    public static void main(String[] args) {
        Field f1 = new Field();
        Field f2 = new Field();
        f1.test(10);
        f1.test(5);
        f2.test(20);
        System.out.println(i + "  " + f1.j + "  " + f1.k);
        System.out.println(i + "  " + f2.j + "  " + f2.k);
    }
}
