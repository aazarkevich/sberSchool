package sberSchool.homeWork5;

import java.lang.reflect.Proxy;

public class CacheProxy implements Calculator {
    private Calculator calculator;

    public CacheProxy(Calculator calculator) {
        ClassLoader calculatorClassLoader = calculator.getClass().getClassLoader();
        Class[] interfaces = calculator.getClass().getInterfaces();
        this.calculator = (Calculator) Proxy.newProxyInstance(calculatorClassLoader, interfaces,
                new CacheProxyInvocationHandler(calculator));
    }

    @Override
    public int calc(int number) {
        return calculator.calc(number);
    }

}
