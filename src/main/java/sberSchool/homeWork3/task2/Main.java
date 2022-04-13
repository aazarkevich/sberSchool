package sberSchool.homeWork3.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> testik = new ArrayList<>(Arrays.asList(1,2,34,5,6));
//        List<Integer> testik2 = new ArrayList<>();
//        CollectionUtils.addAll(testik,testik2);
//        testik.forEach(System.out::println);
    }

    static void test(List<? super Integer> testList) {
        System.out.println(testList.add(0));
//        testList.forEach(System.out::println);
    }
}
