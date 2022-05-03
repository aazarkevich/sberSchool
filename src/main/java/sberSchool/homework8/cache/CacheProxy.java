package sberSchool.homework8.cache;

import sberSchool.homework8.service.Service;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheProxy implements Service {
    private Service service;
    private String rootDirectory;
    private Map<HashMap, Double> cache;

    public CacheProxy(Service service, String rootDirectory) {
        this.rootDirectory = rootDirectory;
        ClassLoader serviceClassLoader = service.getClass().getClassLoader();
        Class[] interfaces = service.getClass().getInterfaces();
        this.service = (Service) Proxy.newProxyInstance(serviceClassLoader, interfaces,
                new CacheProxyInvocationHandler(service, ""));
    }

    @Override
    public double doHardWork(String key, Integer value) {
        return service.doHardWork(key, value);
    }
}
