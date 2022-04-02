package sberSchool.homeWork1.temperature;

public class Temperature {
    public static double toConvertFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
    }

    public static double toConvertKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double toConvertReomura(double celsius) {
        return celsius * 0.8;
    }
}
