package sberSchool.homeWork9;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Streams<T> {
    private List<T> source;
    private List<T> rezult;
    private Streams(List<T> source) {
        this.source = source;
    }

    public static <T> Streams<T> of(List<? extends T> collection) {
        return new Streams(collection);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        rezult = source.stream().filter(predicate).collect(Collectors.toList());
        return this;
    }

    public <R> Streams<T> transform(Function<? super T, ? extends R> mapper) {
        List<T> list = new ArrayList<>();
        for (T t : rezult) {
            R r = mapper.apply(t);
            list.add((T) r);
        }
        rezult = list;
        return this;
    }

    public <K,V> Map<K,V> toMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper) {
        Map<K,V> map = rezult.stream().collect(Collectors.toMap(keyMapper,valueMapper));
        return map;
    }

    public void show() {
        rezult.forEach(System.out::println);
    }

}
