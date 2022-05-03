package sberSchool.homework8.keepers;

import sberSchool.homework8.service.Service;

import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InFileSave {
    private Map<Object[], Object> caches = new HashMap<>();
    private Service service;

    public InFileSave(Service service) {
        this.service = service;
    }

    public double SaveFile(boolean[] saveArgs, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
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

//        try (FileOutputStream fos = new FileOutputStream("test.ser");
//        ) {
//
//        }

        return (double) method.invoke(service, args);
    }


    private double findRezult() {
        return 0;
    }
}
