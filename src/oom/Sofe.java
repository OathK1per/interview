package oom;

/**
 * Stack Over Flow Error
 * @author Yuanping Zhang
 * @date
 */
public class Sofe {
    public static void main(String[] args) {
        stack();
    }

    private static void stack() {
        stack();
    }
}
