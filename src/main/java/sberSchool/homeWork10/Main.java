package sberSchool.homeWork10;


public class Main {
    public static void main(String[] args) {
//        RandomNumbers.createFile("numbers.txt", 50);
//        long k = 1;
//        for (int i = 1; i < 50 ; i++) {
//            k = k * i;
//        }
//        System.out.println(k);

        ThreadFactorial threadFactorial = new ThreadFactorial("numbers.txt");
        threadFactorial.startFindFactorials();
    }
}
