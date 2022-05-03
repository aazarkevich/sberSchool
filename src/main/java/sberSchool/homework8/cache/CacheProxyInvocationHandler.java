package sberSchool.homework8.cache;

import sberSchool.homework8.keepers.InMemorySave;
import sberSchool.homework8.service.Service;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CacheProxyInvocationHandler implements InvocationHandler {
    private Service service;
    private InMemorySave inMemorySave;
    private String rootDirectory;
    public CacheProxyInvocationHandler(Service service, String rootDirectory) {
        this.service = service;
        inMemorySave = new InMemorySave(service);
        this.rootDirectory = rootDirectory;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            Cache annotation = method.getAnnotation(Cache.class);
            if (method.getAnnotation(Cache.class).cachetype() == CacheType.IN_MEMORY) {
                boolean[] saveArgs = annotation.saveArgs();
                double rezult = inMemorySave.saveMemory(saveArgs, method, args);
                return rezult;
            } else {

            }
        }

        return method.invoke(service, args);
    }

}
