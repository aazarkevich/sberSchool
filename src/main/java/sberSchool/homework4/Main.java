package sberSchool.homework4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Bill, Integer> mapBill = Map.of(new Bill(1,2000), 1234,new Bill(2, 3333), 4321);
        mapBill.entrySet().forEach(System.out::println);

//        Bill b = mapBill.keySet().stream().filter(v -> v.getId() == 1).count();
        System.out.println();
    }
}
