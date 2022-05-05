package sberSchool.homework8.service;

import sberSchool.homework8.cache.Cache;
import sberSchool.homework8.cache.CacheType;

import java.util.List;

public interface Service {
    @Cache(cachetype = CacheType.FILE, fileNamePrefix = "Data",
            zip = true, saveArgs = {true, true})
    double doHardWork(String key, Integer value);
    
}
