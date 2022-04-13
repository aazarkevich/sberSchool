package sberSchool.homeWork3.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List testik = new ArrayList<>(Arrays.asList(1,2,34,5,6));
        List<Number> testik2 = new ArrayList<>(Arrays.asList(1,2,34,5,6));
//        List<Integer> testik2 = new ArrayList<>();
//        CollectionUtils.addAll(testik,testik2);
//        List list = CollectionUtils.limit(testik, 3);
//        list.forEach(System.out::println);
//        System.out.println(CollectionUtils.indexOf(testik, 2));
//        CollectionUtils.add(testik,24);
//        testik.forEach(System.out::println);
//        CollectionUtils.removeAll(testik2,testik);
//        testik2.forEach(System.out::println);

//        System.out.println(CollectionUtils.containsAll(testik,testik2));
//        System.out.println(CollectionUtils.containsAny(testik, testik2));

        Integer.compare(1,5);
    }

    static void test(List<? super Integer> testList) {
        System.out.println(testList.add(0));
//        testList.forEach(System.out::println);
    }
}
