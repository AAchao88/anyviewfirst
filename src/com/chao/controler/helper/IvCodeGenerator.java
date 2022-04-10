package com.chao.controler.helper;

public class IvCodeGenerator {

    private static Integer CODE_LENGTH = 6;
    private static Integer PRIME1 = 13;
    private static Integer SALT = 123;
    private static Integer ARY = 36;
    private static Integer PRIME2 = 7;
    private static String HEX_36_Array = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public  String inviCode(int id) {
        id = id * PRIME1;
        id = id + SALT;
        int[] b = new int[CODE_LENGTH];
        b[0] = id;
        for (int i = 0; i < 5; ++i) {
            b[i + 1] = b[i] / ARY;
            b[i] = (b[i] + b[0] * i) % ARY;
        }
        b[4] = (b[0] + b[1] + b[2]) * PRIME1 % ARY;
        b[5] = (b[3] + b[4] + b[5]) * PRIME1 % ARY;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; ++i) {
            sb.append(HEX_36_Array.charAt(b[(i * PRIME2) % CODE_LENGTH]));
        }
        return sb.toString();
    }
}
