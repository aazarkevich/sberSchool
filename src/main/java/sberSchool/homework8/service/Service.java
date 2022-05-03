package sberSchool.homework8.service;

import sberSchool.homework8.cache.Cache;
import sberSchool.homework8.cache.CacheType;

public interface Service {
    @Cache(cachetype = CacheType.IN_MEMORY, fileNamePrefix = "",
            zip = false, identityBy = {String.class, Integer.class})
    double doHardWork(String key, Integer value);
}
