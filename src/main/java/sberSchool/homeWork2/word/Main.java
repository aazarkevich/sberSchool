package sberSchool.homeWork2.word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String src = "C:\\Users\\Артем\\IdeaProjects\\sberSchool\\src\\main\\java\\sberSchool\\homeWork2\\word\\words.txt";
        File file = new File(src);
        //1
        System.out.println(file.countUniqueWord());
        //2
        System.out.println(file.uniqueWordSortedLength());
        //3
        System.out.println(file.countRepeatWord());
        //4
        System.out.println(file.reverseText());
        //5
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        reverseIterator(numbers);
        //6
        System.out.println(file.choseLine(10));
    }

    //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке
    static void reverseIterator(List list) {
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}