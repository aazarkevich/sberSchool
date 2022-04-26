package sberSchool.homeWork5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceProxyInvocationHandler implements InvocationHandler {

    private Calculator calculator;

    public PerformanceProxyInvocationHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            long start = System.nanoTime();
            Object rezult = method.invoke(calculator,args);
            long finish = System.nanoTime();
            System.out.printf("Время выполнения метода с анотацией Metric: %s нс \n" , (finish - start));
            return rezult;
        }

        return method.invoke(calculator,args);
    }
}
