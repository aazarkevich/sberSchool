package sberSchool.homeWork3.task2;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> List limit(List<? extends T> source, int size) {
//        return newArrayList(source.subList(0,size));
        return null;
    }
}
