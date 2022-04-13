package sberSchool.homeWork3.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {
        return new ArrayList(source.subList(0,size));
    }


    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        c2.forEach(v -> removeFrom.remove(v));

    }

    public static <T> boolean containsAll(List<? extends T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T elem: c2) {
            if(c1.contains(elem)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, Object min, Object max) {
        List<T> result = new ArrayList<>();
        for (T elem : list) {
            if (elem.compareTo((T) min) >= 0 && elem.compareTo((T) max) <= 0) {
                result.add(elem);
            }
        }
        Collections.sort(result);
        return result;
    }

}
