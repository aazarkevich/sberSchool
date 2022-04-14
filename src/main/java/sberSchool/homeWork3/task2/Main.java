package sberSchool.homeWork3.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list1 = new ArrayList<>(Arrays.asList(1,2,34,5,6));
        List<Number> list2 = new ArrayList<>();

        System.out.println("CollectionUtils.addAll()");
        CollectionUtils.addAll(list1, list2);
        list2.forEach(System.out::println);
        System.out.println("----------");

        System.out.println("CollectionUtils.newArraylist()");
        List<Integer> newList = new ArrayList<>();

        System.out.println("CollectionUtils.indexOf()");
        System.out.println(CollectionUtils.indexOf(list1, 2));
        System.out.println("----------");

        System.out.println("CollectionUtils.limit()");
        List subList = CollectionUtils.limit(list1,3);
        subList.forEach(System.out::println);
        System.out.println("----------");

        System.out.println("CollectionUtils.add()");
        CollectionUtils.add(list1, 55);
        list1.forEach(System.out::println);
        System.out.println("----------");

        System.out.println("CollectionUtils.removeAll()");
        CollectionUtils.removeAll(list2, Arrays.asList(1,2,34));
        list2.forEach(System.out::println);
        System.out.println("----------");

        System.out.println("CollectionUtils.containsAll()");
        System.out.println(CollectionUtils.containsAll(list1,list2));
        System.out.println("----------");

        System.out.println("CollectionUtils.containsAny()");
        System.out.println(CollectionUtils.containsAny(list1, list2));
        System.out.println("----------");

        System.out.println("CollectionUtils.range()");
        System.out.println(CollectionUtils.range(list1,1,6));
        System.out.println("----------");
    }

}
