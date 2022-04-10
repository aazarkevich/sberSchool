package sberSchool.homeWork2.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>() {{
           add(new Car("Лада", "Хэтчбек"));
           add(new Car("Лада", "седан"));
           add(new Car("Мерседес", "Хэтчбек"));
           add(new Car("Мерседес", "седан"));
           add(new Car("Бмв", "кроссовер"));
           add(new Car("Форд", "Хэтчбек"));
           add(new Car("Форд", "седан"));
           add(new Car("Пежо", "кроссовер"));
           add(new Car("Тойота", "седан"));
           add(new Car("Фольсваген", "седан"));
        }};

        List<Car> sedan = cars.stream().filter(car -> car.getType().equalsIgnoreCase("седан")).collect(Collectors.toList());
        sedan.forEach(System.out::println);
        System.out.println("--------------------");
        List<Car> hatchback = cars.stream().filter(car -> car.getType().equalsIgnoreCase("хэтчбек")).collect(Collectors.toList());
        hatchback.forEach(System.out::println);
        System.out.println("--------------------");
        List<Car> crossover = cars.stream().filter(car -> car.getType().equalsIgnoreCase("кроссовер")).collect(Collectors.toList());
        crossover.forEach(System.out::println);
        System.out.println("--------------------");

    }

}
