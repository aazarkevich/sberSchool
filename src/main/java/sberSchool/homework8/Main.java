package sberSchool.homework8;

import sberSchool.homework8.cache.CacheProxy;
import sberSchool.homework8.service.Service;
import sberSchool.homework8.service.ServiceImpl;

public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        CacheProxy cacheProxy = new CacheProxy(service, "");
        System.out.println(cacheProxy.doHardWork("sdf", 123));
        System.out.println(cacheProxy.doHardWork("sdf", 123));
    }
}
