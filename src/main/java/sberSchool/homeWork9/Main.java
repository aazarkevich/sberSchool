package sberSchool.homeWork9;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        RandomNumbers.createFile("numbers.txt", 50);
//        long k = 1;
//        for (int i = 1; i < 50 ; i++) {
//            k = k * i;
//        }
//        System.out.println(k);

        ThreadFactorial threadFactorial = new ThreadFactorial("numbers.txt");
        threadFactorial.show();
    }
}
