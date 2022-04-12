package sberSchool.homeWork3.task1;

import java.util.Map;

public interface CountMap<T> {
    void add(T element);

    int getCount(T element);

    //current count
    int remove(T element);

    int size();

    void addAll(CountMap source);

    Map toMap();

    void toMap(Map destination);
}
