package sberSchool.homeWork9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadFactorial{
    private String fileFactorial;
    private List<Integer> numbers = new ArrayList<>();

    public ThreadFactorial(String fileFactorial) {
        this.fileFactorial = fileFactorial;
    }

    private void readFile() {
        try(BufferedReader in = new BufferedReader(new FileReader(fileFactorial))) {
            String line;
            while ((line = in.readLine()) != null) {
                this.numbers.add(Integer.parseInt(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        readFile();
        numbers.forEach(System.out::println);
    }
}
