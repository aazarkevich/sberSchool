package sberSchool.homeWork5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CacheProxyInvocationHandler implements InvocationHandler {
    private Map<Integer, Object> rezultCalc = new HashMap<>();
    private Calculator calculator;

    public CacheProxyInvocationHandler(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class) && args[0].getClass() == Integer.class) {

            Integer value = (Integer) args[0];
            if (rezultCalc.containsKey(value)) {
                System.out.println("Значение из кэша.");
                return rezultCalc.get(value);
            } else {
                System.out.println("Вычисленное значение");
                rezultCalc.put(value, method.invoke(calculator, args));
                return rezultCalc.get(value);
            }

        }
        return method.invoke(calculator, args);
    }
}
