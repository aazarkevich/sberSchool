package sberSchool.homework8.service;


import sberSchool.homework8.cache.Cache;
import sberSchool.homework8.cache.CacheType;

import java.nio.file.FileAlreadyExistsException;
import java.util.Map;

public class ServiceImpl implements Service {

    @Override
    @Cache(cachetype = CacheType.FILE, fileNamePrefix = "",
            zip = false, identityBy = {String.class, Integer.class}, saveArgs = {false, false})
    public double doHardWork(String key, Integer value) {

        return value * 10;
    }
}
