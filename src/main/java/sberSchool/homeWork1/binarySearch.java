package sberSchool.homeWork1;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
    public static void main(String[] args) {
        int[] numbers = numbers(100);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 100: ");
        int findNumber = scanner.nextInt();
        binarySearch(numbers, findNumber);
    }

    static int[] numbers(int length) {
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = i;
        }
        return numbers;
    }

    static int binarySearch(int[] mass, int number) {
        int low = 0;
        int high = mass.length - 1;

        while (low <= high) {
            int middle = (high + low) / 2;
            System.out.printf("middle: %s, high: %s, low: %s \n", middle, high, low);
            if (mass[middle] == number) {
                System.out.printf("число %s яв-ся %s элементом массива.", number, middle);
                return middle;
            } else if (mass[middle] > number) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        System.out.println("В массиве нет такого числа.");
        return -1;
    }
}
