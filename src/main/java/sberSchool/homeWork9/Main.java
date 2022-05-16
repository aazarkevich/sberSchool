package sberSchool.homeWork9;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Person1", 25),
                new Person("Person2", 26),
                new Person("Person3", 27),
                new Person("Person4", 28))
        );
        Map map = Streams.of(persons)
                .filter(person -> person.getAge() > 25)
                .transform((person) -> new Person(person.getName(), person.getAge() + 30))
                .toMap(person -> person.getName(), person -> person.getAge());
        map.entrySet().forEach(System.out::println);

    }
}
