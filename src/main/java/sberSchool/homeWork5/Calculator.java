package sberSchool.homeWork5;

public interface Calculator {

    /**
     * Расчет факториала числа
     * @param number
     * */
    @Metric
    @Cache
    int calc(int number);
}
