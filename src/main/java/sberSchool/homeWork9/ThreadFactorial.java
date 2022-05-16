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
                numbers.add(Integer.parseInt(line));
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

    private long calculateFactorials(int number) {
        long rezult = 1;
        for (int i = 1; i < number; i++) {
            rezult *= i;
        }
        return rezult;
    }

    public void startFindFactorials() {
        readFile();
        for (int i = 0; i < numbers.size() - 1; i++) {
            int index = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (numbers) {
                        System.out.println(calculateFactorials(numbers.get(index)));
                        System.out.println();
                    }
                }
            });
            System.out.println(thread.getName());
            thread.start();
        }
    }
}
