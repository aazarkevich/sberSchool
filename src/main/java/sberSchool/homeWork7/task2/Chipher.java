package sberSchool.homeWork7.task2;

import java.util.Arrays;

public class Chipher {

    public static byte[] encode(byte[] bytes, int value) {
        byte[] rezult = Arrays.copyOf(bytes,bytes.length);
        for (int i = 0; i < rezult.length; i++) {
            rezult[i] = (byte) (rezult[i] + value);
        }
        return rezult;
    }

    public static byte[] decode(byte[] bytes, int value) {
        byte[] rezult = Arrays.copyOf(bytes,bytes.length);
        for (int i = 0; i < rezult.length; i++) {
            rezult[i] = (byte) (rezult[i] - value);
        }
        return rezult;
    }
}
