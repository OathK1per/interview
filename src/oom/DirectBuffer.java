package oom;

import java.nio.ByteBuffer;

import static sun.misc.VM.maxDirectMemory;

/**
 * Direct Buffer Memory
 * @author Yuanping Zhang
 * @date
 */
public class DirectBuffer {
    public static void main(String[] args) {
        System.out.println("MaxDirectMemory: " + (maxDirectMemory() / (double) 1024 / 1024) + "MB");

        ByteBuffer bytes = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
