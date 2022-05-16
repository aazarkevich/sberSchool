package sberSchool.homeWork10;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumbers {

    public static void createFile(String nameFile, int range) {
        try(FileWriter fileWriter = new FileWriter(nameFile, false))
        {
            Random random = new Random();
            for(int i = 0; i < 5; i++) {
                fileWriter.write(Integer.toString(random.nextInt(range)) + "\n");
                fileWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
