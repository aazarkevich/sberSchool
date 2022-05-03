package sberSchool.homework8.keepers;

import sberSchool.homework8.service.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InMemorySave {
    private Map<Object[], Object> caches = new HashMap<>();
    private Service service;

    public InMemorySave(Service service) {
        this.service = service;
    }

    public double saveMemory(boolean[] saveArgs, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object rezult = null;
        for (Object[] key: caches.keySet()) {
            if(Arrays.equals(key,args)) {
                System.out.println("CASHES");
                return (double) caches.get(key);
            }
        }

        if (saveArgs[0] == saveArgs[1] && saveArgs[0] != false) {
            caches.put(args, method.invoke(service, args));

        } else if (saveArgs[0] && !saveArgs[1]) {
            Object[] argsOne  = Arrays.copyOf(args, 1);
            caches.put(argsOne, method.invoke(service, args));
        } else {
            Object[] argsTwo = Arrays.copyOfRange(args, 1, 2);
            caches.put(argsTwo, method.invoke(service, args));
        }
        return (double) method.invoke(service, args);
    }

}
