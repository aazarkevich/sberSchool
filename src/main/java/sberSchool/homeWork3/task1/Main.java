package sberSchool.homeWork3.task1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CountMap sourceMap = new CountMapImpl();
        sourceMap.add("john");
        sourceMap.add("artem");
        sourceMap.add("petr");

        CountMap countMap = new CountMapImpl<>();
        countMap.add("john");
        countMap.add("john");
        countMap.add("john");
        countMap.add("ivan");
        countMap.add("ivan");
        countMap.add("petr");
        countMap.add("harry");

        System.out.printf("John добавлялся: %s \n",countMap.getCount("john"));
        System.out.println("---------------");
        System.out.printf("Удалился Ivan, он добавлялся: %s \n", countMap.remove("ivan"));
        System.out.println("---------------");
        System.out.printf("количество разных элементов: %s \n", countMap.size());
        System.out.println("---------------");
        System.out.println("До добавления source ");
        countMap.toMap().entrySet().forEach(System.out::println);
        countMap.addAll(sourceMap);
        System.out.println("после добавления source ");
        countMap.toMap().entrySet().forEach(System.out::println);
        System.out.println("---------------");
        System.out.println("Вернуть java.util.Map. ключ - добавленный элемент начение - количество его добавлений");
        countMap.toMap().entrySet().forEach(System.out::println);
        System.out.println("---------------");
        Map destination = new HashMap();
        countMap.toMap(destination);
        destination.entrySet().forEach(System.out::println);
    }
}
