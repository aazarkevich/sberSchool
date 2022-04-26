package sberSchool.homeWork5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        //Задание 1
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(5));
//        Задание 2 Вывести на консоль все методы класса, включая все родительские методы
        Test1 test1 = new Test2();
        printMethods(test1);
//        Задание 3 Вывести все геттеры класса
        System.out.println("------Getters------");
        printGetters(test1);
//        Задание 4 Проверить что все String константы имеют значение = их имени
        System.out.printf("Все string константы имеют значение = их имени: %s \n",equalConstant(new WeekDays()));
//        Задание 5 Кэшируемый прокси
        Calculator calculator1 = new CacheProxy(calculator);
        System.out.println(calculator1.calc(5));
        System.out.println(calculator1.calc(5));
        //Задание 6
        Calculator calculator2 = new PerformanceProxy(calculator);
        System.out.println(calculator2.calc(5));
        //Задание 7 BeanUtils
        Person person1 = new Person("Nik", 30);
        Person person2 = new Person();
        System.out.println("До вызова BeanUtils.assign()");
        System.out.printf("Person1: %s, Person2: %s \n", person1, person2);
        BeanUtils.assign(person2,person1);
        System.out.println("После ");
        System.out.printf("Person1: %s, Person2: %s", person1, person2);

    }

    static void printMethods(Object object) {
        Class<?> classObject = object.getClass();
        while(classObject != null) {
            Method[] methodsClass = classObject.getDeclaredMethods();
            for (Method method : methodsClass) {
                System.out.printf("Название метода: %s \n", method.getName());
            }
            classObject = classObject.getSuperclass();
        }
    }

    static void printGetters(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
                System.out.printf("Getter: %s \n", method.getName());
            }
        }
    }

    static boolean equalConstant(Object object) {
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field: declaredFields) {
            try {
                field.setAccessible(true);
                Object value = field.get(clazz);
                if(!field.getName().equals(value)) {
                    return false;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}

abstract class Test1 {
    private String nameTest;
    private int CountTest;

    public String getNameTest() {
        return nameTest;
    }

    public void setNameTest(String nameTest) {
        this.nameTest = nameTest;
    }

    public int getCountTest() {
        return CountTest;
    }

    private void setCountTest(int countTest) {
        CountTest = countTest;
    }
}

class Test2 extends Test1 {

    public void runTest() {
        System.out.println("test run.");
    }

    private void stopTest() {
        System.out.println("test stop.");
    }

}