package sberSchool.homeWork5;

import java.lang.reflect.Proxy;

public class PerformanceProxy implements Calculator {

    private Calculator calculator;

    public PerformanceProxy(Calculator calculator) {
        ClassLoader calculatorClassLoader = calculator.getClass().getClassLoader();
        Class[] interfaces = calculator.getClass().getInterfaces();
        this.calculator = (Calculator) Proxy.newProxyInstance(calculatorClassLoader, interfaces,
                new PerformanceProxyInvocationHandler(calculator));
    }

    @Override
    public int calc(int number) {
        return calculator.calc(number);
    }
}
