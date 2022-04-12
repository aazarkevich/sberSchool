package sberSchool.homeWork3.task1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T element) {
        map.put(element, map.containsKey(element) ? map.get(element) + 1 : 1);
    }

    @Override
    public int getCount(T element) {
        return map.get(element);
    }

    @Override
    public int remove(T element) {
        int count = map.get(element);
        map.remove(element);
        return count;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap source) {
        for(Object key: source.toMap().keySet()) {
            add((T) key);
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map destination) {
        destination.putAll(map);
    }
}
