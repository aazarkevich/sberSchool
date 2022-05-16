package sberSchool.homeWork10;


public class Main {
    public static void main(String[] args) {
        ThreadFactorial threadFactorial = new ThreadFactorial("numbers.txt");
        threadFactorial.startFindFactorials();
    }
}
