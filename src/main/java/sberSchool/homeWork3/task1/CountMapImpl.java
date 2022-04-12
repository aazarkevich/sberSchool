package sberSchool.homeWork3.task1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T element) {
        if(map.containsKey(element)) {
//            map.get(element)
        }
    }

    @Override
    public int getCount(T element) {
        return 0;
    }

    @Override
    public int remove(T element) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addAll(CountMap source) {

    }

    @Override
    public Map toMap() {
        return null;
    }

    @Override
    public void toMap(Map destination) {

    }
}
