package sberSchool.homework8.cache;

import sberSchool.homework8.keepers.InFileSave;
import sberSchool.homework8.keepers.InMemorySave;
import sberSchool.homework8.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CacheProxyInvocationHandler implements InvocationHandler {
    private Service service;
    private InMemorySave inMemorySave;
    private String rootDirectory;
    private InFileSave inFileSave;

    public CacheProxyInvocationHandler(Service service, String rootDirectory) {
        this.service = service;
        inMemorySave = new InMemorySave(service);
        inFileSave = new InFileSave(service);
        this.rootDirectory = rootDirectory;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
        if (method.isAnnotationPresent(Cache.class)) {
            Cache annotation = method.getAnnotation(Cache.class);
            System.out.println(method.getAnnotation(Cache.class).cachetype());

            if (annotation.cachetype() == CacheType.IN_MEMORY) {
                boolean[] saveArgs = annotation.saveArgs();
                double rezult = inMemorySave.saveMemory(saveArgs, method, args);
                return rezult;
            } else {
                boolean[] saveArgs = annotation.saveArgs();
                String namePrefix = annotation.fileNamePrefix();
                double rezult = inFileSave.SaveFile(saveArgs, method, args, namePrefix);
                if(annotation.zip()) {
                    inFileSave.zip(namePrefix);
                }
                return rezult;
            }
        }

        return method.invoke(service, args);
    }

}
